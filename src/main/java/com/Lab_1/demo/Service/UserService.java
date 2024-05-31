package com.Lab_1.demo.Service;

import com.Lab_1.demo.Entity.Request.UserDtoReq;
import com.Lab_1.demo.Entity.Response.PostDtoRes;
import com.Lab_1.demo.Entity.Response.UserDtoRes;

import java.util.List;

public interface UserService {

    List<UserDtoRes> findAllUsers();
    UserDtoRes findUserById(Long id);
    UserDtoRes saveUser(UserDtoReq userDtoReq);
    List<PostDtoRes> findPostsByUserId( Long id);
}
