package com.mongo.starter.service.common;

import com.mongo.starter.service.common.dto.CommonDTO;
import com.mongo.starter.service.common.dto.DefaultDTO;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class MongoCommonService<ID, E extends DefaultDTO, R extends MongoRepository<E, ID>> extends ListCrudService<ID, E, R> {

	@Getter
	@Setter(onMethod_ = @Autowired)
	R repository;

	@Getter
	private Class<E> entityClass;

	@Getter
	private String entityId;

	@PostConstruct
	public void init() {
		Type clazz = getClass().getGenericSuperclass();
		//제네릭 객체에 대한 실제 할당된 type을 가져온다 List<Entity> -> Entity
		var type = ((ParameterizedType) clazz).getActualTypeArguments()[1];
		entityClass = (Class<E>) type;
		recursiveSuper(entityClass);
	}

	private void recursiveSuper(Class<?> clazz){
		if(!clazz.equals(CommonDTO.class)){
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				var idAntt = field.getAnnotation(Id.class);
				if (idAntt != null) {
					entityId = field.getName();
				}
//			EntityKey dt = field.getAnnotation(EntityKey.class);
//			if (dt != null) {
//				putKeyMap(field.getName(), dt);
//			}
			}
			recursiveSuper(clazz.getSuperclass());
		}

	}

}
