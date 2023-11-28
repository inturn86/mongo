package com.mongo.starter.service.mdm.user.repository;

import com.mongo.starter.service.mdm.user.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

}
