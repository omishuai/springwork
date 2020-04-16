package com.shuai.test.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Greeting {
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	private final long id;
	private final String content;

	public Greeting(long id, String content) {
			this.content = content;
			this.id = id;
	}
}