package com.mongo.starter.service.common;

import com.mongo.starter.service.common.CrudService;
import com.mongo.starter.service.common.dto.DefaultDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class ListCrudService <ID, E extends DefaultDTO, R extends MongoRepository<E, ID>> extends CrudService<ID, E, R> {

	public List<E> getList() {
		return getRepository().findAll();
	}

	public List<E> getList(E entity) {
		return getRepository().findAll(Example.of(entity));
	}

	public List<E> getList(E entity, Sort sort) {
		return getRepository().findAll(Example.of(entity), sort);
	}

	@Transactional
	public void saveList(List<E> entityList) {
		getRepository().saveAll(entityList);
	}

	@Transactional
	public void deleteList(List<E> entityList) {
		getRepository().deleteAll(entityList);
	}

}
