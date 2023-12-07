package com.mongo.starter.biz;

import com.mongo.starter.manager.process.DocProcessInterface;
import com.mongo.starter.service.mdm.department.DepartmentEntity;
import com.mongo.starter.service.mdm.department.DepartmentService;
import com.mongo.starter.service.mdm.user.UserEntity;
import com.mongo.starter.service.mdm.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserBizService {

	private final DepartmentService departmentService;

	private final UserService userService;


	@Transactional
	public ResponseEntity<Object> saveUserAndDepartment(UserEntity user) {

		DepartmentEntity department = new DepartmentEntity();
		department.setDepartmentName("S/W");
		DepartmentEntity departmentEntity = departmentService.saveDepartment(department);

		user.setDepartmentId(department.getDepartmentId());

		userService.save(user);

		return ResponseEntity.ok().body(user);
	}
}
