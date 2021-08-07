package com.api.mongo.springbootmongodb.exception;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.mongo.springbootmongodb.model.BaseModel;
import com.api.mongo.springbootmongodb.model.MessageModel;
import com.api.mongo.springbootmongodb.model.ResponseModel;
import com.api.mongo.springbootmongodb.util.BootcampConstants;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	private Environment properties;
	
	@ExceptionHandler(BootcampException.class)
	public ResponseEntity<BaseModel> handleBootcampExceptions(final BootcampException ex, final HttpServletRequest req){
		if(StringUtils.isNotBlank(ex.getMessage())) {
			MessageModel message = getMessage(ex.getMessage(), ex.getValues());
			ResponseModel response = new ResponseModel(BootcampConstants.STATUS_FAILURE,message.getCode(),Collections.singletonList(message.getMessage()),null);
			return new ResponseEntity<>(response, ex.getHttpStatus());
		}
		return null;
	}

	private MessageModel getMessage(String message, String[] values) {
		final MessageModel messageToShow = new MessageModel();
		messageToShow.setCode(properties.getProperty(message+".code"));
		messageToShow.setMessage(properties.getProperty(message+".message"));
		return messageToShow;
	}

}
