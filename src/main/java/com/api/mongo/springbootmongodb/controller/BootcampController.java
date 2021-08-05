package com.api.mongo.springbootmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mongo.springbootmongodb.assembler.BootcampAssembler;
import com.api.mongo.springbootmongodb.exception.BootcampException;
import com.api.mongo.springbootmongodb.model.BaseModel;
import com.api.mongo.springbootmongodb.model.BootcampModel;
import com.api.mongo.springbootmongodb.service.BootcampService;
import com.api.mongo.springbootmongodb.util.BootcampConstants;

@RestController
@RequestMapping("/bootcamps")
public class BootcampController {

	@Autowired
	private BootcampService bootcampService;

	@Autowired
	private BootcampAssembler bootcampAssembler;

	@GetMapping
	public ResponseEntity<BaseModel> getAllBootcamps() throws BootcampException  {
		return bootcampAssembler.getResponse(bootcampService.getAllBootcamps());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<BaseModel> getBootcampById(@PathVariable("id") final String id) throws BootcampException {
		return bootcampAssembler.getResponse(bootcampService.getBootcampById(id));
	}

	@PostMapping
	public ResponseEntity<BaseModel> createBootcamp(@RequestBody final BootcampModel bootcamp) throws BootcampException {
		final String status = bootcampService.createBootcamp(bootcamp);
		return bootcampAssembler.getResponse(bootcamp, status,BootcampConstants.FLOW_BOOTCAMP_CREATE ,HttpStatus.CREATED);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<BaseModel> updateBootcamp(@RequestBody final BootcampModel bootcamp, @PathVariable("id") final String id) throws BootcampException {
		final String status = bootcampService.updateBootcamp(bootcamp, id);
		return bootcampAssembler.getResponse(bootcamp, status, BootcampConstants.FLOW_BOOTCAMP_UPDATE, HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<BaseModel> deleteBootcamp(@PathVariable("id") final String id) throws BootcampException {
		final String status = bootcampService.deleteBootcamp(id);
		return bootcampAssembler.getResponse(null, status, BootcampConstants.FLOW_BOOTCAMP_DELETE, HttpStatus.OK);
	}

}
