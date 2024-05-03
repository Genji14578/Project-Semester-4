package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Comment;

import com.example.demo.entities.Product;

@Repository("commentRepository")
public interface CommentRepository extends CrudRepository<Comment, Integer> {

	@Query(value = "select * from Comment where status like :status and product_id like :product_id order by comment_id desc limit :n", nativeQuery = true)
	public List<Comment> findLastest(@Param("n") int n, @Param("status") boolean status,
			@Param("product_id") int product_id);

	@Modifying
	@Transactional
	@Query(value = "delete from comment where account_id =:id", nativeQuery = true)
	public void delete_comment_account_id(@Param("id") int id);

	@Query(value = "select * from comment", nativeQuery = true)
	public Iterable<Comment> findall();
}
