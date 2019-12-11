package com.example.redis.service.impl;

import com.example.redis.domain.Post;
import com.example.redis.repo.PostRepository;
import com.example.redis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getById(String id) {
        Optional<Post> optional = postRepository.findById(id);
        return optional.orElse(new Post());
    }

    @Override
    public List<Post> getAll() {
        return StreamSupport
                .stream(postRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(String id) {
        postRepository.deleteById(id);
    }

    @Override
    public void delete(Post post) {

    }
}
