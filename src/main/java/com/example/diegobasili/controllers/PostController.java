package com.example.diegobasili.controllers;

import com.example.diegobasili.enetities.Post;
import com.example.diegobasili.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class PostController {
    @Autowired
    private PostsService postService;

    @GetMapping
    private List<Post> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Post createPost(@RequestBody Post body) {
        return postService.savePost(body);
    }

    @GetMapping("/{postId}")
    private Post getPostById(@PathVariable int postId) {
        return postService.findById(postId);
    }

    @PutMapping("/{postId}")
    private Post findPostByIdAndUpdate(@PathVariable int postId, @RequestBody Post body) {
        return postService.findByIdAndUpdate(postId, body);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findPostByIdAndDelete(@PathVariable int postId) {
        postService.findByIdAndDelete(postId);
    }
}
