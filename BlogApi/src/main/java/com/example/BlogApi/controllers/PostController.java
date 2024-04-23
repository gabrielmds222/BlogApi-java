package com.example.BlogApi.controllers;

import com.example.BlogApi.excepctions.ResourceNotFoundException;
import com.example.BlogApi.models.Post;
import com.example.BlogApi.repositories.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {
    private PostRepository postRepository;

    PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    List<Post> all() {
        return postRepository.findAll();
    }

    @PostMapping("/posts")
    public Post createNewPost(@RequestBody Post newPost) {
        return postRepository.save(newPost);
    }
}
