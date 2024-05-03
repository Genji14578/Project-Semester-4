package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findByLastestAndCategory(int n, int cate_id) {
		return productRepository.findByLastestAndCategory(n, cate_id);
	}

	@Override
	public List<Product> findByCategory(int cate_id, Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(cate_id, pageable);
	}

	@Override
	public List<Product> search(int cate_id, String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.search(cate_id, keyword, pageable);
	}

	@Override
	public Product searchById(int id) {
		// TODO Auto-generated method stub
		return productRepository.searchById(id);
	}

}
