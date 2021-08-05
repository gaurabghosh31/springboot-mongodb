package com.api.mongo.springbootmongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mongo.springbootmongodb.model.BootcampModel;
import com.api.mongo.springbootmongodb.model.BootcampsModel;
import com.api.mongo.springbootmongodb.repository.BootcampRepository;
import com.api.mongo.springbootmongodb.util.BootcampConstants;

@Service
public class BootcampService {

	@Autowired
	private BootcampRepository bootcampRepository;

	public BootcampsModel getAllBootcamps() {
		return (BootcampsModel) bootcampRepository.findAll();
	}

	public BootcampModel getBootcampById(String id) {
		return bootcampRepository.findById(id).orElse(null);
	}

	public String createBootcamp(BootcampModel bootcamp) {
		try {
			bootcampRepository.save(bootcamp);
			return BootcampConstants.STATUS_SUCCESS;
		} catch (Exception ex) {
			return BootcampConstants.STATUS_FAILURE;
		}
	}

	public String updateBootcamp(BootcampModel bootcamp, String id) {
		try {
			final BootcampModel existingBootcamp = bootcampRepository.findById(id).orElse(null);
			if (null != existingBootcamp) {
				bootcamp.setId(existingBootcamp.getId());
				bootcampRepository.save(bootcamp);
			}
			return BootcampConstants.STATUS_SUCCESS;
		} catch (Exception ex) {
			return BootcampConstants.STATUS_FAILURE;
		}
	}

	public String deleteBootcamp(String id) {
		try {
			bootcampRepository.deleteById(id);
			return BootcampConstants.STATUS_SUCCESS;
		} catch (Exception ex) {
			return BootcampConstants.STATUS_FAILURE;
		}
	}

}
