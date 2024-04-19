package com.example.BlogApi.repositories;

import com.example.BlogApi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
