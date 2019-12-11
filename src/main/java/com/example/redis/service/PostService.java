package com.example.redis.service;

import com.example.redis.domain.Post;

import java.util.List;

public interface PostService {
    Post getById(String id);

    List<Post> getAll();

    Post save(Post post);

    Post update(Post post);

    void delete(String id);

    void delete(Post post);
}
