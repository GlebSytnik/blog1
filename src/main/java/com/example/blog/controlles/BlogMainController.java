package com.example.blog.controlles;


import com.example.blog.models.Post;
import com.example.blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogMainController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog-main")
    public String blog(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("blog-main/blog-add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("blog-main/blog-add")
    public String blogPostAdd(@RequestParam String anons, @RequestParam String fullText1, @RequestParam String title, Model model) {
        Post post = new Post(anons, fullText1, title);
        postRepository.save(post);
        return "redirect:/blog-main";
    }

    @GetMapping("blog-main/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

}
