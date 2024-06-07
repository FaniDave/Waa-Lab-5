package com.Lab_1.demo.Repo;

import com.Lab_1.demo.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
