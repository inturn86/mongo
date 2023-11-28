package com.mongo.starter.service.mdm.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mdm_user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

	@Id
	protected String userId;

	protected String userName;

	protected String departmentId;

	protected String email;

}
