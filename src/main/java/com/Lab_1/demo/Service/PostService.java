package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;

import java.util.List;

public interface PostService {

      List<PostDtoRes> findAll();
      PostDtoRes findById(long id);
      void save(PostDtoReq post);
      void deleteById(long id);
      void updatePostById(long id, PostDtoReq post);
      List<PostDtoRes> findPostsByTitle(String title);  // Add this method to the interface
}
