package com.mongo.starter.service.mdm.user;

import com.mongo.starter.exception.api.ApiException;
import com.mongo.starter.service.mdm.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public UserEntity saveUser(UserEntity user){

//		log.error(" user count {}", userRepository.count());
//		userRepository.save(user);
//		user.setUserId(null);

		if(true) {
			throw new ApiException();
		}

		log.error(" user count {}", userRepository.count());
		return userRepository.save(user);
	}

	public UserEntity getUser(String id) {
		return userRepository.findById(id).orElse(null);
	}
}
