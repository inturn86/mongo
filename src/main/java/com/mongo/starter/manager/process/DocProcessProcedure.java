package com.mongo.starter.manager.process;

import org.springframework.stereotype.Component;

@Component
public class DocProcessProcedure implements DocProcessInterface{
	@Override
	public String processingProcedure(String docName) {
		return String.format("Process %s", docName);
	}
}
