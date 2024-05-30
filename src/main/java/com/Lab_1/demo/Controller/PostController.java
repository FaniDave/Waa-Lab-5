package com.Lab_1.demo.Controller;

import com.Lab_1.demo.Entity.Post;
import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;
import com.Lab_1.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

        PostService postService;

        @Autowired
        public PostController(PostService postService) {
            this.postService = postService;
        }

        @GetMapping
        public List<PostDtoRes> getAllPosts() {
             return postService.getAllPosts();
        }

        @GetMapping("/{id}")
        public PostDtoRes getPostById(@PathVariable("id") long id) {
              return postService.getPostById(id);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void addPost(@RequestBody PostDtoReq post) {
              postService.addPost(post);
        }

        @DeleteMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deletePostById(@PathVariable long id) {
             postService.deletePostById(id);
        }

        @PutMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updatePostById(@PathVariable long id, @RequestBody PostDtoReq post) {
              postService.updatePostById(id, post);
        }
}
