package com.Lab_1.demo.Entity.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostDtoReq {
      //Instance fields
      private long id;
      private String title;
      private String content;
      private String author;
}
