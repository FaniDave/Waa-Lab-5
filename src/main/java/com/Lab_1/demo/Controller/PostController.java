package com.Lab_1.demo.Controller;

import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;
import com.Lab_1.demo.Service.PostService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@NoArgsConstructor
public class PostController {

        PostService postService;

        @GetMapping
        public List<PostDtoRes> findAll() {
             return postService.findAll();
        }

        @GetMapping("/{id}")
        public PostDtoRes findById(@PathVariable("id") long id) {
              return postService.findById(id);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void save(@RequestBody PostDtoReq post) {
              postService.save(post);
        }

        @DeleteMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById(@PathVariable long id) {
             postService.deleteById(id);
        }

        @PutMapping("{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updatePostById(@PathVariable long id, @RequestBody PostDtoReq post) {
              postService.updatePostById(id, post);
        }
}
