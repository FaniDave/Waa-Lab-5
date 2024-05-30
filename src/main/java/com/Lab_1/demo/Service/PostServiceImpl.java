package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Post;
import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;
import com.Lab_1.demo.Repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

        PostRepo postRepo;
        ModelMapper modelMapper;

        @Autowired
        public PostServiceImpl(PostRepo postRepo, ModelMapper modelMapper) {
            this.postRepo = postRepo;
            this.modelMapper = modelMapper;
        }

        public List<PostDtoRes> getAllPosts() {
            return postRepo.getAllPosts().stream().map(post -> modelMapper.map(post, PostDtoRes.class)).toList();
        }

        public PostDtoRes getPostById(long id) {
            return  modelMapper.map(postRepo.getPostById(id), PostDtoRes.class);
        }


        public void addPost(PostDtoReq post) {
             Post postEntity = modelMapper.map(post, Post.class);
             postRepo.addPost(postEntity);
        }

        public void deletePostById(long id) {
             postRepo.deletePostById(id);
        }

        public void updatePostById(long id, PostDtoReq post) {
            Post postEntity = modelMapper.map(post, Post.class);
             postRepo.updatePostById(id, postEntity);
        }
}
