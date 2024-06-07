package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Request.CommentDtoReq;
import com.Lab_1.demo.Entity.Response.CommentDtoRes;

import java.util.List;

public interface CommentService {

        List<CommentDtoRes> findAll();
        CommentDtoRes findById(long id);
        void save(CommentDtoReq comment);
        void deleteById(long id);
        void updateCommentById(long id, CommentDtoReq comment);
}
