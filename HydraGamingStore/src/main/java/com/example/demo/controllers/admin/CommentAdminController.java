package com.example.demo.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Comment;
import com.example.demo.services.CommentService;

@Controller
@RequestMapping("/admin/comment**")
public class CommentAdminController {
	@Autowired
	CommentService commentService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("comments", commentService.findall());
		return "admin.comment";
	}

	@RequestMapping(value = "delete_comment/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		commentService.delete(id);
		redirectAttr.addFlashAttribute("msg", "Delete invoice successful");
		return "admin.comment";
	}

	@RequestMapping(value = "active/{id}")
	public String active(@PathVariable("id") int id) {
		Comment comment = commentService.find(id);
		comment.setStatus(true);
		commentService.save(comment);
		return "admin.success";
	}
}
