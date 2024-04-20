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
    public Post adicionaPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @DeleteMapping("/posts/{id}")
    void deletaPost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> editaPost(@PathVariable Long id, @RequestBody Post postEditado) {
        Post editaPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("O post não foi encontrado"));

        editaPost.setTitulo(postEditado.getTitulo());
        editaPost.setDescricao(postEditado.getDescricao());
        editaPost.getPreco(postEditado.getPreco(postEditado.getPreco()));

        postRepository.save(editaPost);

        return ResponseEntity.ok(editaPost);
    }
}
