package com.example.redis.controller;

import com.example.redis.domain.Post;
import com.example.redis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ModelAndView getAllPast() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");

        modelAndView.addObject("list", postService.getAll());
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/post/save")
    public ModelAndView savePost(@ModelAttribute Post post) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");
        post.setId(UUID.randomUUID().toString());
        postService.save(post);

        modelAndView.addObject("list", postService.getAll());
        return modelAndView;
    }

    @GetMapping("/post/delete/{id}")
    public ModelAndView deletePost(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post");
        postService.delete(id);

        modelAndView.addObject("post", new Post());
        modelAndView.addObject("list", postService.getAll());
        return modelAndView;
    }
}
