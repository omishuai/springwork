package com.shuai.test.actuatorService;

public class Greeting {
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	private final long id;
	private final String content;

	Greeting(long id, String content) {
			this.content = content;
			this.id = id;
	}
}