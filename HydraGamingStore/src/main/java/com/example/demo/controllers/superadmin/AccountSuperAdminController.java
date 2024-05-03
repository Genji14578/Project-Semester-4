package com.example.demo.controllers.superadmin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.services.AccountService;
import com.example.demo.services.CommentService;
import com.example.demo.services.InvoiceDetailService;
import com.example.demo.services.InvoiceService;
import com.example.demo.services.RoleService;

@Controller
@RequestMapping("/super_admin**")
public class AccountSuperAdminController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "superadmin.index";
	}

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(Model model, ModelMap modelMap,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "1") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		model.addAttribute("accounts", accountService.findAll(pageable));
		return "superadmin.show";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		invoiceDetailService.delete_invoice_detail_account_id(id);
		invoiceService.delete_invoice_account_id(id);
		commentService.delete_comment_account_id(id);
		roleService.delete_role_account_id(id);
		accountService.delete_account(id);
		redirectAttr.addFlashAttribute("msg", "Delete invoice successful");
		return "superadmin.index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		Account account = new Account();
		List<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		modelMap.put("genders", gender);
		modelMap.put("account", account);
		return "superadmin.add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("account") Account account, ModelMap modelMap) {
		accountService.save(account);
		return "superadmin.success";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(ModelMap modelMap) {
		Account account = new Account();
		List<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		modelMap.put("genders", gender);
		modelMap.put("account", account);
		return "superadmin.update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("invoice") Invoice invoice) {
		invoiceService.save(invoice);
		return "superadmin.success";
	}
}
