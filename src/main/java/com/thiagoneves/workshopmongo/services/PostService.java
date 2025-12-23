package com.thiagoneves.workshopmongo.services;

import com.thiagoneves.workshopmongo.domain.Post;
import com.thiagoneves.workshopmongo.domain.User;
import com.thiagoneves.workshopmongo.repository.PostRepository;
import com.thiagoneves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        System.out.println(post.get().getTitle());
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
