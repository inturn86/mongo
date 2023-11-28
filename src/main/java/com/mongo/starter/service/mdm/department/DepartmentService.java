package com.mongo.starter.service.mdm.department;

import com.mongo.starter.service.mdm.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

	private final DepartmentRepository departmentRepository;

	@Transactional
	public DepartmentEntity saveDepartment(DepartmentEntity entity) {
		return departmentRepository.save(entity);
	}

	public List<DepartmentEntity> getList(DepartmentEntity entity) {

		return departmentRepository.findAll(Example.of(entity));
	}

	public DepartmentEntity getListById(String id) {
		return departmentRepository.findById(id).orElse(null);
	}
}
