package com.Lab_1.demo.Repo;

import com.Lab_1.demo.Entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{

          //Fake database
          private List<Post> posts = new ArrayList<>(List.of(
                  new Post(472, "WAP", "html, css and js", "Tina"),
                  new Post(545, "WAA", "ReactJs and SpringBoot", "Muheydin"),
                  new Post(401, "MPP", "Core java", "Lerman")
          ));

          //getAllPosts
          public List<Post> getAllPosts () {
               return posts;
          }

          //getPostById
          public Post getPostById(long id) {
                Post post = null;
                for(Post p: posts) {
                     if(p.getId() == id) {
                         post = p;
                     }
                }
                return post;
          }

          //addPost
          public void addPost(Post post) {
                 if(!posts.contains(post)) {
                     posts.add(post);
                 }
          }

          //deletePostById
          public void deletePostById(long id) {
               posts = posts.stream().filter(p -> p.getId() == id).toList();
          }

          //updatePostById method
          public void updatePostById(long id, Post post) {
                for(Post p: posts) {
                     if(p.getId() == id) {
                         p.setTitle(post.getTitle());
                         p.setContent(post.getContent());
                         p.setId(post.getId());
                         p.setAuthor(post.getAuthor());
                     }
                }
          }
}
