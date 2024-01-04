package com.mongo.starter.service.common;

import com.mongo.starter.service.common.dto.DefaultDTO;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPagingService<ID, E extends DefaultDTO, R extends MongoRepository<E, ID>> extends IService<ID, E, R>{

	default <D extends DefaultDTO> Page<E> getPagingList(E entity, Pageable page) {
		return getRepository().findAll(Example.of(entity), page);
	}

	default <D extends DefaultDTO> Page<E>  getPagingListBySort(E entity, Pageable page, Sort sort) {
		Pageable paging = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);
		return getRepository().findAll(Example.of(entity), page);
	}
}
