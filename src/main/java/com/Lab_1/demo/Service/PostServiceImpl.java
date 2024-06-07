package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Request.PostDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;
import com.Lab_1.demo.Entity.Post;
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
public class PostServiceImpl implements PostService {

    private PostRepo postRepo;
    private ModelMapper modelMapper;

    @Override
    public List<PostDtoRes> findAll() {
        return postRepo.findAll().stream().map(post -> modelMapper.map(post, PostDtoRes.class)).toList();
    }

    @Override
    public PostDtoRes findById(long id) {
        return modelMapper.map(postRepo.findById(id).orElse(null), PostDtoRes.class);
    }

    @Override
    public void save(PostDtoReq post) {
        Post postEntity = modelMapper.map(post, Post.class);
        postRepo.save(postEntity);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updatePostById(long id, PostDtoReq postDtoReq) {
        Post postEntity = postRepo.findById(id).orElse(null);
        if (postEntity != null) {
            postEntity.setTitle(postDtoReq.getTitle());
            postEntity.setContent(postDtoReq.getContent());
            postEntity.setAuthor(postDtoReq.getAuthor());
            postRepo.save(postEntity);
        }
    }

    @Override
    public List<PostDtoRes> findPostsByTitle(String title) {  // Override this method
        return postRepo.findPostsByTitle(title).stream().map(post -> modelMapper.map(post, PostDtoRes.class)).toList();
    }
}
