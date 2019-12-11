package com.example.redis.service;

import com.example.redis.domain.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    Post getById(String id);

    Page<Post> getAll(int page, int size);

    Post save(Post post);

    Post update(Post post);

    void delete(String id);

    void delete(Post post);
}
