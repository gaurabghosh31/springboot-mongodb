package com.api.mongo.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.mongo.springbootmongodb.model.BootcampModel;

@Repository
public interface BootcampRepository extends MongoRepository<BootcampModel, String>{

}
