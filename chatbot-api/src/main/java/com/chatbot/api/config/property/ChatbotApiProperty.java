package com.chatbot.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("chatbot")
public class ChatbotApiProperty {

	private String originPermited = "http://localhost:4200";

	public String getOriginPermited() {
		return originPermited;
	}

	public void setOriginPermited(String originPermited) {
		this.originPermited = originPermited;
	}

}
