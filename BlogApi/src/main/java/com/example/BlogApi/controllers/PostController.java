package com.example.BlogApi.controllers;

import com.example.BlogApi.models.Post;
import com.example.BlogApi.repositories.PostRepository;
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
    public Post adicionaPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @DeleteMapping("/posts/{id}")
    void deletaPost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}
