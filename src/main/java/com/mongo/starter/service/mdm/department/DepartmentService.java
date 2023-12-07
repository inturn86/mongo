package com.mongo.starter.service.mdm.department;

import com.mongo.starter.service.common.MongoCommonService;
import com.mongo.starter.service.mdm.department.dto.DepartmentDTO;
import com.mongo.starter.service.mdm.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService extends MongoCommonService<String, DepartmentEntity, DepartmentRepository> {

	private final DepartmentRepository departmentRepository;

	//TODO - CRUD 처리와 Paging 처리 관련 로직 개발
	//TODO - DTO 데이터도 처리.
	//TODO - Entity, DTO 공통화 처리 Service 개발.

	@Transactional
	public DepartmentEntity saveDepartment(DepartmentEntity entity) {
		return departmentRepository.save(entity);
	}

	//key 값을 꺼내야하는데 그럴꺼면 @Id의 name을 get하여 처리.
	@Transactional
	public DepartmentEntity modifyDepartment(DepartmentDTO dto) {

		//이전 값을 조회.
		DepartmentEntity departmentEntity = departmentRepository.findById(dto.getDepartmentId()).orElse(null);

		//patch는 없을 경우는 error
		if(departmentEntity == null)    throw new RuntimeException();

		//TODO - Entity를 조회하여 이전값에 적용.
		//TODO - ModelMapper 관련 설정 로직 추가.
		ModelMapper mapper = new ModelMapper();
		//TODO - 변경 사항에 대해서만 수정 처리. == 확인.
		mapper.map(dto, departmentEntity);

		return departmentRepository.save(departmentEntity);
	}

	public List<DepartmentEntity> getList(DepartmentEntity entity) {
		return departmentRepository.findAll(Example.of(entity));
	}

	public DepartmentEntity getListById(String id) {
		return departmentRepository.findById(id).orElse(null);
	}
}
