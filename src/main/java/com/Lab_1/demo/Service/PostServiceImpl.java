package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Post;
import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;
import com.Lab_1.demo.Repo.PostRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostServiceImpl implements PostService{

        PostRepo postRepo;
        ModelMapper modelMapper;

        public List<PostDtoRes> findAll() {
            return postRepo.findAll().stream().map(post -> modelMapper.map(post, PostDtoRes.class)).toList();
        }

        public PostDtoRes findById(long id) {
            return  modelMapper.map(postRepo.findById(id), PostDtoRes.class);
        }


        public void save(PostDtoReq post) {
             Post postEntity = modelMapper.map(post, Post.class);
             postRepo.save(postEntity);
        }

        public void deleteById(long id) {
             postRepo.deleteById(id);
        }

        public void updatePostById(long id, PostDtoReq postDtoReq) {
            Post postEntity = postRepo.findById(id).get();
            postEntity.setTitle(postDtoReq.getTitle());
            postEntity.setContent(postDtoReq.getContent());
            postEntity.setAuthor(postDtoReq.getAuthor());
            postRepo.save(postEntity);
        }
}
