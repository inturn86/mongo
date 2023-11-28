package com.mongo.starter.api.backoffice.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DefaultResponse {
	protected String code;
	protected String message;
}
