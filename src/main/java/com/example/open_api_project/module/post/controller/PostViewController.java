package com.example.open_api_project.module.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostViewController {

    @GetMapping("/posts")
    public String showPosts() {
        return "posts/main";
    }

}
