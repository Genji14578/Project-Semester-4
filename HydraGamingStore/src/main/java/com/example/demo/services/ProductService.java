package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entities.Product;

public interface ProductService {
	
	public List<Product> findByLastestAndCategory(int n,int cate_id);
	
	public List<Product> findByCategory(int cate_id,Pageable pageable);
	
	public List<Product> search(int cate_id,String keyword,Pageable pageable);
	
	public Product searchById(int id);

}
