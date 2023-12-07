package com.mongo.starter.messagequeue.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongo.starter.service.mdm.user.UserEntity;
import com.mongo.starter.service.mdm.user.UserService;
import com.mongo.starter.service.mdm.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Slf4j
@Component
@RequiredArgsConstructor
public class MasterDataListener {

	private final ObjectMapper mapper;

	private final UserService userService;

	//ConsumerRecords 는 단독 param만 사용.
	//batch option 사용할 경우는 ack 사용 불가
	@KafkaListener(topics = "cdctestsrv1.mydb.mdm_user", groupId = "cdc_group", containerFactory = "batchKafkaListenerContainerFactory")
	public void userDataListener(ConsumerRecords<String, String> recordList) throws JsonProcessingException {
		log.error("$$$ userDataListener data = {}" + recordList);
		List<UserEntity> syncUserEntityList = new ArrayList<>();
		for (ConsumerRecord<String, String> record : recordList) {
			String recordValue = record.value();

			//삭제일 경우 데이터가 null 이 되는 케이스가 있는데 ConsumerInterceptor를 활용하여 필터처리.
			log.error("*** UserEntity value = *** {}", recordValue);
			if(StringUtils.isEmpty(recordValue))    continue;
			//TODO - UserEntity로 direct받지 말고 ? 받는게 낫나 ???..아닌거같음.
			//TODO - 또는 저장시 MongoIgnore 처리.
			syncUserEntityList.add(mapper.readValue(recordValue, UserEntity.class));
		}
		userService.saveUserCRUDList(syncUserEntityList);
	}

	@KafkaListener(topics = "cdctestsrv1.mydb.test_table", groupId = "cdc_group")
	public void testDataListener(ConsumerRecord<String, Map<String, String>> record, Acknowledgment ack) {
		log.error("$$$ testDataListener topic = {}" + record.topic());
		log.error("$$$ testDataListener data = {}" + record.toString());
		ack.acknowledge();
	}
}
