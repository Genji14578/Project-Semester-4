package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@Controller
@RequestMapping(value = { "products" }) // Controller mac dinh
public class ProductsController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "{category}/page/{a}" }, method = RequestMethod.GET)
	public String index(@PathVariable("category") int category, @PathVariable("a") int a, HttpServletRequest request,
			ModelMap modelMap) {
		if (a < 0) {
			a = 0;
		}

		List<Product> products = productService.findByCategory(category, new PageRequest(a, 12));
		if (products.isEmpty()) {
			products = productService.findByCategory(category, new PageRequest(a - 1, 12));
			a = a - 1;
		}

		PagedListHolder<List<Product>> pagedListHolder = new PagedListHolder((ArrayList<Product>) products);

		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(12);
		modelMap.put("pagedListHolder", pagedListHolder);

		modelMap.put("back", (a - 1));
		modelMap.put("next", (a + 1));
		modelMap.put("cate", category);
		return "products.index"; // tiles.xml
	}

	@RequestMapping(value = { "{category}/{keyword}/page/{a}" }, method = RequestMethod.POST)
	public String search(@PathVariable("category") int category, @PathVariable("keyword") String keyword,
			@PathVariable("a") int a, HttpServletRequest request, ModelMap modelMap) {
		if (a < 0) {
			a = 0;
		}

		List<Product> products = productService.search(category, keyword, new PageRequest(a, 12));
		if (products.isEmpty()) {
			products = productService.findByCategory(category, new PageRequest(a - 1, 12));
			a = a - 1;
		}

		PagedListHolder<List<Product>> pagedListHolder = new PagedListHolder((ArrayList<Product>) products);

		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(12);
		modelMap.put("pagedListHolder", pagedListHolder);

		modelMap.put("back", (a - 1));
		modelMap.put("next", (a + 1));
		modelMap.put("cate", category);
		return "products.index"; // tiles.xml
	}
}