package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Post;
import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;

import java.util.List;

public interface PostService {

      //abstract method
      List<PostDtoRes> findAll();
      PostDtoRes findById(long id);
      void save(PostDtoReq post);
      void deleteById(long id);
      void updatePostById(long id, PostDtoReq post);
}
