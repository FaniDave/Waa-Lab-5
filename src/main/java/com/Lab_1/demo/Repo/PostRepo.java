package com.Lab_1.demo.Repo;

import com.Lab_1.demo.Entity.Post;

import java.util.List;

//PostRepo interface
public interface PostRepo {

      //abstract methods
      List<Post> getAllPosts();
      Post getPostById(long id);
      void addPost(Post post);
      void deletePostById(long id);
      void updatePostById(long id, Post post);
}
