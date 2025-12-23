package com.thiagoneves.workshopmongo.repository;

import com.thiagoneves.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostRepository extends MongoRepository<Post, String> {

}
