package com.mongo.starter.service.mdm.department;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mdm_department")
@Setter
@Getter
@NoArgsConstructor
public class DepartmentEntity {

	@Id
	private String departmentId;

	private String departmentName;

}
