package com.mongo.starter.service.mdm.department.repository;

import com.mongo.starter.service.mdm.department.DepartmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<DepartmentEntity, String> {
}
