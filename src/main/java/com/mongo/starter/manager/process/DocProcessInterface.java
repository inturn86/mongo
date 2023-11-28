package com.mongo.starter.manager.process;

import com.mongo.starter.biz.UserBizService;

import java.sql.DriverManager;
import java.util.Collections;
import java.util.EnumSet;
import java.util.concurrent.CopyOnWriteArrayList;

public interface DocProcessInterface extends DocDefaultProcessInterface{

	public static String getDocName() {
		return "s";
	}

	default String processingDoc(String s) {
		CopyOnWriteArrayList<String> testList = new CopyOnWriteArrayList<>();
		return processingProcedure(s);
	}

	public static void main(String[] args) {
//		List<UserBizService> list = EnumSet.of(UserBizService.class);
		String test = "test";
		System.out.println(test.hashCode());

		String test2 = "test";
		System.out.println(test2.hashCode());

		System.out.println(test.equals(test2));


		System.out.println("test");
	}
}
