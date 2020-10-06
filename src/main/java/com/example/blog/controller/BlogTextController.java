package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogTextController {
    private PostRepository postRepository;

    @Autowired
    public BlogTextController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("blog-main/blog-text")
    public String text(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-text";
    }
}
