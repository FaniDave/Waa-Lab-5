package com.Lab_1.demo.Entity.Response;

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
public class UserDtoRes {
    private long id;
    private String name;
    private List<Post> posts;
}
