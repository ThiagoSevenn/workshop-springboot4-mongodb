package com.thiagoneves.workshopmongo.repository;

import com.thiagoneves.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User, String> {

}
