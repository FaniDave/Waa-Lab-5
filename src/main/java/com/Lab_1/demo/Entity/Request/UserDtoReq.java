package com.Lab_1.demo.Entity.Request;

import com.Lab_1.demo.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoReq {

    String name;
    List<Post> posts;

}
