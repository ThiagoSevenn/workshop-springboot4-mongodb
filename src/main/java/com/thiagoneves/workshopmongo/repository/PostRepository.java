package com.thiagoneves.workshopmongo.repository;

import com.thiagoneves.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;


public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'title': {$regex: ?0, $options: 'i' } }") // consulta simples modificada.
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text); // consulta pronta.

    // Consulta Complexa, avalia se a data minima e a data máxima são maior igual, menor igual, respectivamente, e avalia se existe essa string no titulo, corpo ou comentários do post.
    @Query(" { $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
