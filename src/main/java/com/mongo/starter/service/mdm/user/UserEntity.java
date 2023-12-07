package com.mongo.starter.service.mdm.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mongo.starter.define.annotation.MonogEntityKey;
import com.mongo.starter.service.common.dto.CdcCommonDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mdm_user")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserEntity extends CdcCommonDTO {

	@Id @MonogEntityKey
	protected String userId;

	protected String userName;

	protected String departmentId;

	protected String email;

}
