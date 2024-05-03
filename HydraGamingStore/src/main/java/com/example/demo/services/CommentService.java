package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Comment;
import com.example.demo.entities.Product;

public interface CommentService {
	public List<Comment> findLastest(int comment_id, boolean status, int product_id);

	public void save(Comment comment);

	public void delete_comment_account_id(int id);

	public Iterable<Comment> findall();

	public void delete(int id);

	public Comment find(int id);

}
