package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Comment;
import com.Lab_1.demo.Entity.Request.CommentDtoReq;
import com.Lab_1.demo.Entity.Response.CommentDtoRes;
import com.Lab_1.demo.Repo.CommentRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CommentServiceImpl implements CommentService {

    private CommentRepo commentRepo;
    private ModelMapper modelMapper;

    @Override
    public List<CommentDtoRes> findAll() {
        return commentRepo.findAll().stream().map(comment -> modelMapper.map(comment, CommentDtoRes.class)).toList();
    }

    @Override
    public CommentDtoRes findById(long id) {
        return modelMapper.map(commentRepo.findById(id).orElse(null), CommentDtoRes.class);
    }

    @Override
    public void save(CommentDtoReq commentDtoReq) {
        Comment comment = modelMapper.map(commentDtoReq, Comment.class);
        commentRepo.save(comment);
    }

    @Override
    public void deleteById(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void updateCommentById(long id, CommentDtoReq commentDtoReq) {
        Comment comment = commentRepo.findById(id).orElse(null);
        if (comment != null) {
            comment.setName(commentDtoReq.getName());
            commentRepo.save(comment);
        }
    }
}
