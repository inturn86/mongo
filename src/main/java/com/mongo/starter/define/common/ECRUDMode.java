package com.mongo.starter.define.common;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ECRUDMode {

	C("c"), R("r"), U("u"), D("d");

	protected String code;
}
