package com.mongo.starter.controller.mdm;

import com.mongo.starter.biz.UserBizService;
import com.mongo.starter.manager.process.DocProcessProcedure;
import com.mongo.starter.service.mdm.user.UserEntity;
import com.mongo.starter.service.mdm.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	private final UserBizService userBizService;

	private final DocProcessProcedure docProcessProcedure;

	@GetMapping("/{id}")
	public UserEntity getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@PostMapping
	public UserEntity saveUser(@RequestBody UserEntity user) {
		return userService.saveUser(user);
	}

	@PostMapping("/department")
	public void saveUserAndDepartment(@RequestBody UserEntity user) {

		docProcessProcedure.processingDoc("test");
		userBizService.saveUserAndDepartment(user);
	}
}
