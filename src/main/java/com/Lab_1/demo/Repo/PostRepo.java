package com.Lab_1.demo.Repo;

import com.Lab_1.demo.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//PostRepo interface
public interface PostRepo extends JpaRepository<Post, Long> {

}
