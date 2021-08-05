package com.api.mongo.springbootmongodb.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.mongo.springbootmongodb.exception.BootcampException;
import com.api.mongo.springbootmongodb.model.BaseModel;
import com.api.mongo.springbootmongodb.model.BootcampModel;
import com.api.mongo.springbootmongodb.model.BootcampsModel;
import com.api.mongo.springbootmongodb.model.MessageModel;
import com.api.mongo.springbootmongodb.model.ResponseModel;
import com.api.mongo.springbootmongodb.util.BootcampConstants;

@Component
public class BootcampAssembler {
	
	@Autowired
	private Environment properties;

	public ResponseEntity<BaseModel> getResponse(BootcampsModel allBootcamps) throws BootcampException {
		if(null != allBootcamps.getBootcamps() && !allBootcamps.getBootcamps().isEmpty()) {
			final ResponseModel response = new ResponseModel(BootcampConstants.STATUS_SUCCESS, null, null, allBootcamps);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		throw new BootcampException(BootcampConstants.ERROR_MESSAGE_NO_DATA_FOUND, null, HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<BaseModel> getResponse(BootcampModel bootcampById) throws BootcampException {
		if(null != bootcampById){
			final ResponseModel response = new ResponseModel(BootcampConstants.STATUS_SUCCESS, null, null, bootcampById);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		throw new BootcampException(BootcampConstants.ERROR_MESSAGE_NO_DATA_FOUND, null, HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<BaseModel> getResponse(BootcampModel bootcamp, String status, String flow, HttpStatus httpStatus) throws BootcampException {
		if(status == BootcampConstants.STATUS_SUCCESS){
			final ResponseModel response = new ResponseModel(BootcampConstants.STATUS_SUCCESS, null, null, bootcamp);
			return new ResponseEntity<>(response, httpStatus);
		}
		throw new BootcampException(getErrorMessage(flow), null, HttpStatus.BAD_REQUEST);
	}

	private String getErrorMessage(String flow) {
		switch(flow) {
		case BootcampConstants.FLOW_BOOTCAMP_CREATE:
			return BootcampConstants.ERROR_MESSAGE_BOOTCAMP_CREATE_FAILED;
		case BootcampConstants.FLOW_BOOTCAMP_UPDATE:
			return BootcampConstants.ERROR_MESSAGE_BOOTCAMP_UPDATE_FAILED;
		case BootcampConstants.FLOW_BOOTCAMP_DELETE:
			return BootcampConstants.ERROR_MESSAGE_BOOTCAMP_DELETE_FAILED;
		default:
			return BootcampConstants.EMPTY_STRING;
		}
	}
	
	private MessageModel getMessage(String message, String[] values) {
		final MessageModel messageToShow = new MessageModel();
		messageToShow.setCode(properties.getProperty(message+".code"));
		messageToShow.setMessage(properties.getProperty(message+".message"));
		return messageToShow;
	}


}
