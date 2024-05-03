package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Account;
import com.example.demo.entities.Comment;
import com.example.demo.entities.Item;
import com.example.demo.entities.Product;
import com.example.demo.services.CommentService;
import com.example.demo.services.ProductService;

@Controller
@RequestMapping(value = { "product" }) // Controller mac dinh
public class ProductsSingleController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CommentService commentService;

	public void loadData(ModelMap modelMap) {
		List<Product> products1 = productService.findByLastestAndCategory(6, 1);
		List<Product> products2 = productService.findByLastestAndCategory(6, 2);
		List<Product> products3 = productService.findByLastestAndCategory(6, 3);

		modelMap.put("products1", products1);
		modelMap.put("products2", products2);
		modelMap.put("products3", products3);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String index(@PathVariable("id") int id, ModelMap modelMap) {
		Product product = productService.searchById(id);
		List<Comment> comments = commentService.findLastest(3, true, id);

		System.out.println("count: " + comments.size());

		modelMap.put("product", product);
		modelMap.put("comments", comments);
		return "products.single"; // tiles.xml
	}

	@RequestMapping(value = "review/product_id={id}", method = RequestMethod.GET)
	public String review(HttpServletRequest httpServletRequest, @PathVariable("id") int id, ModelMap modelMap) {
		HttpSession session = httpServletRequest.getSession();
		Account account = (Account) session.getAttribute("account");
		if (account == null) {
			modelMap.put("msg", "donothaveAccount");
			loadData(modelMap);
			return "home.index";
		} else {
			System.out.println("account :" + account.getUsername());
			Product product = productService.searchById(id);
			String content = httpServletRequest.getParameter("content");
			int star = Integer.parseInt(httpServletRequest.getParameter("star"));
			commentService.save(new Comment(account, product, content, false, star));
			modelMap.put("msg", "successReview");
			loadData(modelMap);
			return "home.index";
		}

	}
}