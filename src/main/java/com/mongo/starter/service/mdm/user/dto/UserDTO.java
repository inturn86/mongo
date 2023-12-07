package com.mongo.starter.service.mdm.user.dto;

import com.mongo.starter.service.mdm.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Pageable;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserDTO extends UserEntity {
}
