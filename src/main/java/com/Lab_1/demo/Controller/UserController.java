package com.Lab_1.demo.Controller;

import com.Lab_1.demo.Entity.Request.UserDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;
import com.Lab_1.demo.Entity.Response.UserDtoRes;
import com.Lab_1.demo.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/users")
public class UserController {

       private UserService userService;

       @GetMapping
       public List<UserDtoRes> findAllUsers() {
              return userService.findAllUsers();
       }

       @GetMapping("/{id}")
       public UserDtoRes findUserById(@PathVariable Long id) {
              return userService.findUserById(id);
       }

       @PostMapping
       public UserDtoRes saveUser(@RequestBody UserDtoReq userDtoReq) {
              return userService.saveUser(userDtoReq);
       }

       @GetMapping("/{id}/posts")
       public List<PostDtoRes> findPostsByUserId(@PathVariable Long id) {
              return userService.findPostsByUserId(id);
       }

       @GetMapping("/more-than/{n}/posts")
       public List<UserDtoRes> findUsersWithMoreThanNPosts(@PathVariable int n) {
              return userService.findUsersWithMoreThanNPosts(n);
       }
}
