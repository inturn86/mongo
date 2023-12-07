package com.mongo.starter;

import com.mongo.starter.service.mdm.user.UserEntity;
import com.mongo.starter.service.mdm.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MasterDataServiceTests {

	@Autowired
	private UserService userService;


	public MasterDataServiceTests(UserService userService) {
		this.userService = userService;
	}


	//TOOD - 기준 정보 별 Test case 작성
	@DisplayName("유저 등록 Test")
	@Test
	void save_user_tests() {

		final String userId = "test";

		//give
		UserEntity user = UserEntity.builder().userId(userId).userName("test").build();

		//when
		UserEntity resultUser = userService.saveUser(user);

		//then
		assertThat(resultUser.getUserId()).isEqualTo(userId);
	}

}
