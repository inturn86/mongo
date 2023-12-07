package com.mongo.starter.service.mdm.department.dto;

import com.mongo.starter.service.mdm.department.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class DepartmentDTO extends DepartmentEntity {

	private String test;
}
