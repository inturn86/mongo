package com.mongo.starter.service.mdm.department;

import com.mongo.starter.service.common.dto.CdcCommonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mdm_department")
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity extends CdcCommonDTO {

	@Id
	private String departmentId;

	private String departmentName;

}
