package com.mongo.starter.controller.mdm;

import com.mongo.starter.biz.UserBizService;
import com.mongo.starter.manager.process.DocProcessProcedure;
import com.mongo.starter.service.mdm.user.UserEntity;
import com.mongo.starter.service.mdm.user.UserService;
import com.mongo.starter.service.mdm.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	private final UserBizService userBizService;

	private final DocProcessProcedure docProcessProcedure;


	@PostMapping
	public UserEntity saveUser(@RequestBody UserDTO user) {
		return userService.save(user);
	}

	@GetMapping("/{id}")
	public UserEntity getUserDetail(@PathVariable("id") String id) {
		return userService.getDetailById(id);
	}

	@GetMapping
	public List<UserEntity> getUserList(UserEntity dto, Sort sort) {
		return userService.getUserList(dto, sort);
	}

	@GetMapping("/paging")
	public Page<UserEntity> getUserPagingList(UserDTO dto, Pageable paging) {
		return userService.getUserPagingListBySort(dto, paging);
	}
}
