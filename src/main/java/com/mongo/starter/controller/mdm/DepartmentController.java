package com.mongo.starter.controller.mdm;

import com.mongo.starter.service.mdm.department.DepartmentEntity;
import com.mongo.starter.service.mdm.department.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;

	@GetMapping
	public List<DepartmentEntity> getList(@RequestBody DepartmentEntity entity) {
		return departmentService.getList(entity);
	}

	@GetMapping("{id}")
	public DepartmentEntity getListById(@PathVariable String id) {
		return departmentService.getListById(id);
	}
}
