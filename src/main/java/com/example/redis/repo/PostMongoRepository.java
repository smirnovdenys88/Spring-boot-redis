package com.example.redis.repo;

import com.example.redis.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

//Todo KeyValueRepository<Post, String> if you want use only redis
public interface PostMongoRepository extends MongoRepository<Post, String> {
}
