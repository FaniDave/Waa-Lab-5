package com.Lab_1.demo.Controller;

import com.Lab_1.demo.Entity.Comment;
import com.Lab_1.demo.Entity.Request.CommentDtoReq;
import com.Lab_1.demo.Entity.Response.CommentDtoRes;
import com.Lab_1.demo.Service.CommentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@NoArgsConstructor
public class CommentController {

      private CommentService commentService;

      @GetMapping
      public List<CommentDtoRes> findAll() {
            return commentService.findAll();
      }

      @GetMapping("/{id}")
      public CommentDtoRes findById(@PathVariable("id") long id) {
            return commentService.findById(id);
      }

      @PostMapping
      @ResponseStatus(HttpStatus.CREATED)
      public void save(@RequestBody CommentDtoReq comment) {
            commentService.save(comment);
      }

      @DeleteMapping("{id}")
      @ResponseStatus(HttpStatus.NO_CONTENT)
      public void deleteById(@PathVariable long id) {
            commentService.deleteById(id);
      }

      @PutMapping("{id}")
      @ResponseStatus(HttpStatus.NO_CONTENT)
      public void updateCommentById(@PathVariable long id, @RequestBody CommentDtoReq comment) {
            commentService.updateCommentById(id, comment);
      }
}
