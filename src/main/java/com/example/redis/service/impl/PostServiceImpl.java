package com.example.redis.service.impl;

import com.example.redis.domain.Post;
import com.example.redis.repo.PostRedisRepository;
import com.example.redis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
//    @Autowired
//    private PostMongoRepository mongoRepository;

    @Autowired
    private PostRedisRepository redisRepository;

    @Override
    public Post getById(String id) {
        Optional<Post> optional = redisRepository.findById(id);
        return optional.orElse(new Post());
    }

    @Override
    public Page<Post> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return redisRepository.findAll(pageable);
    }

    @Override
    public Post save(Post post) {
        return redisRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return redisRepository.save(post);
    }

    @Override
    public void delete(String id) {
        redisRepository.deleteById(id);
    }

    @Override
    public void delete(Post post) {
    }
}
