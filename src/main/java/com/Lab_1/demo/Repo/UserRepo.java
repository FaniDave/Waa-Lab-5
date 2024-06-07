package com.Lab_1.demo.Repo;

import com.Lab_1.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE size(u.posts) > ?1")
    List<User> findUsersWithMoreThanNPosts(int n);
}
