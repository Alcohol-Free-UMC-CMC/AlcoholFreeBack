package com.example.alcoholfreeback.src.test;

import com.example.alcoholfreeback.src.test.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
