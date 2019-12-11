package com.example.redis.service.impl;

import com.example.redis.domain.Post;
import com.example.redis.repo.PostMongoRepository;
import com.example.redis.repo.PostRedisRepository;
import com.example.redis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMongoRepository mongoRepository;

    @Autowired
    private PostRedisRepository redisRepository;

    @Override
    public Post getById(String id) {
        Optional<Post> optional = mongoRepository.findById(id);
        return optional.orElse(new Post());
    }

    @Override
    public Page<Post> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
//        return StreamSupport
//                .stream(mongoRepository.findAll(pageable).spliterator(), false)
//                .collect(Collectors.toList());
        return mongoRepository.findAll(pageable);
    }

    @Override
    public Post save(Post post) {
        return mongoRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return mongoRepository.save(post);
    }

    @Override
    public void delete(String id) {
        mongoRepository.deleteById(id);
    }

    @Override
    public void delete(Post post) {

    }
}
