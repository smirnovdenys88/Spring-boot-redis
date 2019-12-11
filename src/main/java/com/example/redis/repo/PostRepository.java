package com.example.redis.repo;

import com.example.redis.domain.Post;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface PostRepository extends KeyValueRepository<Post, String> {
}
