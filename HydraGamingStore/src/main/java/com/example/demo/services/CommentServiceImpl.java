package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Comment;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.ProductRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> findLastest(int comment_id, boolean status, int product_id) {
		// TODO Auto-generated method stub
		return commentRepository.findLastest(comment_id, status, product_id);
	}

	@Override
	public void save(Comment comment) {
		// TODO Auto-generated method stub
		commentRepository.save(comment);

	}

	@Override
	public void delete_comment_account_id(int id) {
		// TODO Auto-generated method stub
		commentRepository.delete_comment_account_id(id);
	}

	@Override
	public Iterable<Comment> findall() {
		// TODO Auto-generated method stub
		return commentRepository.findall();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(id);
	}

	@Override
	public Comment find(int id) {
		// TODO Auto-generated method stub
		return commentRepository.findById(id).get();
	}

}
