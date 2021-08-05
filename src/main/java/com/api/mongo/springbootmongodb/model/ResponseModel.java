package com.api.mongo.springbootmongodb.model;

import java.util.List;

public class ResponseModel extends BaseModel {
	private String status;
	private String code;
	private List<String> messages;
	private BaseModel data;

	public ResponseModel(String status, String code, List<String> messages, BaseModel data) {
		super();
		this.status = status;
		this.code = code;
		this.messages = messages;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public BaseModel getData() {
		return data;
	}

	public void setData(BaseModel data) {
		this.data = data;
	}

}
