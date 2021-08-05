package com.api.mongo.springbootmongodb.model;

import java.util.List;

public class BootcampsModel extends BaseModel {

	private List<BootcampModel> bootcamps;

	public List<BootcampModel> getBootcamps() {
		return bootcamps;
	}

	public void setBootcamps(List<BootcampModel> bootcamps) {
		this.bootcamps = bootcamps;
	}

}
