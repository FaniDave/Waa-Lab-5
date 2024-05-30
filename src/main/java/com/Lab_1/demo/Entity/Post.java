package com.Lab_1.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Post class
public class Post {

    //Instance fields
    private long id;
    private String title;
    private String content;
    private String author;

}
