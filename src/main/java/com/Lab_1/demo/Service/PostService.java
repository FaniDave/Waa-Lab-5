package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Post;
import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;

import java.util.List;

public interface PostService {

      //abstract method
      List<PostDtoRes> getAllPosts();
      PostDtoRes getPostById(long id);
      void addPost(PostDtoReq post);
      void deletePostById(long id);
      void updatePostById(long id, PostDtoReq post);
}
