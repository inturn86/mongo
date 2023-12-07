package com.mongo.starter.service.common;

import com.mongo.starter.manager.util.ModelMapperUtils;
import com.mongo.starter.service.common.dto.DefaultDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class CrudService <ID, E extends DefaultDTO, R extends MongoRepository<E, ID>> implements IService<ID, E, R>, IPagingService<ID, E, R> {

	@Transactional
	public E save(E entity) {
		return getRepository().save(entity);
	}

	@Transactional
	public E patch(E entity) {
		E searchEntity = getRepository().findById(getEntityId(entity)).orElse(null);
		ModelMapperUtils.getModelMapper().map(entity, searchEntity);
		return getRepository().save(entity);
	}

	@Transactional
	public E patchWithException(E entity) {
		E searchEntity = getRepository().findById(getEntityId(entity)).orElseThrow(() -> { throw new RuntimeException(); });
		ModelMapperUtils.getModelMapper().map(entity, searchEntity);
		return getRepository().save(entity);
	}

	@Transactional
	public void delete(E entity) {
		getRepository().delete(entity);
	}

	@Transactional
	public void deleteById(ID id) {
		getRepository().deleteById(id);
	}

	public E getDetailById(ID id) {
		return getRepository().findById(id).orElse(null);
	}
}
