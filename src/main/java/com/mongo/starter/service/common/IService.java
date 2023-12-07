package com.mongo.starter.service.common;

import com.mongo.starter.service.common.dto.DefaultDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IService<ID, E extends DefaultDTO, R extends MongoRepository<E, ID>> {

	R getRepository();

	default void setProperty() {

	}

	default ID getEntityId(Object dto) {
		try {
			return (ID) PropertyUtils.getProperty(dto, getEntityId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getEntityId();
}
