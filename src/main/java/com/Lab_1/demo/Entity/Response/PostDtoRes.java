package com.Lab_1.demo.Entity.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//PostDto class
public class PostDtoRes {

       private String title;
       private String content;
       private String author;
}
