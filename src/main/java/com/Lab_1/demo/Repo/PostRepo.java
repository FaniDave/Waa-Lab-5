package com.Lab_1.demo.Repo;

import com.Lab_1.demo.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//PostRepo interface
public interface PostRepo extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.title = ?1")
    List<Post> findPostsByTitle(String title);

}
