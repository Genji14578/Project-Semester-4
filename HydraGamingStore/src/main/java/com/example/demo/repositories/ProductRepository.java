package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("from Product where productName like %:keyword%")
	public List<Product> search(@Param("keyword") String keyword);
	
	@Query("from Product where id like :id")
	public Product searchById(@Param("id") int id);

	@Query(value = "select * from Product where category_id like :cate_id order by id desc limit :n", nativeQuery = true)
	public List<Product> findByLastestAndCategory(@Param("n") int n, @Param("cate_id") int cate_id);

	@Query(value = "select * from Product where category_id like :cate_id", nativeQuery = true)
	public List<Product> findByCategory(@Param("cate_id") int cate_id, Pageable pageable);

	@Query(value = "select * from Product where category_id like :cate_id and product_name like %:keyword%", nativeQuery = true)
	public List<Product> search(@Param("cate_id") int cate_id, @Param("keyword") String keyword,
			Pageable pageable);
}
