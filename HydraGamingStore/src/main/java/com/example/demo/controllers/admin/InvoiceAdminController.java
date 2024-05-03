package com.example.demo.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import com.example.demo.entities.InvoiceDetail;
import com.example.demo.repositories.InvoiceRepository;
import com.example.demo.services.AccountService;
import com.example.demo.services.InvoiceDetailService;
import com.example.demo.services.InvoiceService;

@Controller
@RequestMapping("/admin/invoice**")
public class InvoiceAdminController {
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest httpServletRequest) {
		return "admin.index";
	}

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String findAll(ModelMap modelMap, Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "1") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		model.addAttribute("invoices", invoiceService.findAll(pageable));
		return "admin.show";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		Invoice invoice = new Invoice();
		List<String> trade_type = new ArrayList<String>();
		List<Boolean> status = new ArrayList<Boolean>();
		trade_type.add("Cash");
		trade_type.add("Paypal");
		trade_type.add("Point");
		status.add(true);
		status.add(false);
		modelMap.put("invoice", invoice);
		modelMap.put("payment", trade_type);
		modelMap.put("statuss", status);
		modelMap.put("accounts", accountService.findAll());
		return "admin.add";
	}

	@RequestMapping(value = "delete/{method}/{id}")
	public String delete(@PathVariable("method") String method, @PathVariable("id") int id,
			RedirectAttributes redirectAttr) {
		if (method.equalsIgnoreCase("invoice")) {
			invoiceDetailService.delete_invoice(id);
			invoiceService.delete(id);
			redirectAttr.addFlashAttribute("msg", "Delete invoice successful");
		}
		return "admin.index";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(ModelMap modelMap) {
		try {
			Invoice invoice = new Invoice();
			List<String> status = new ArrayList<String>();
			List<String> trade_type = new ArrayList<String>();
			modelMap.put("accounts", accountService.findAll());
			status.add("true");
			status.add("false");
			trade_type.add("Cash");
			trade_type.add("Paypal");
			trade_type.add("Point");
			modelMap.put("invoice", invoice);
			modelMap.put("statuss", status);
			modelMap.put("payment", trade_type);
		} catch(Exception e) {
			modelMap.put("msg", "cannotUpdate");
			return "redirect:/admin/invoice/show";
		}
		return "admin.update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("invoice") Invoice invoice, ModelMap modelMap) {
		try {
			invoiceService.save(invoice);
		}  catch(Exception e) {
			modelMap.put("msg", "cannotUpdate");
			return "redirect:/admin/invoice/show";
		}
		

		return "admin.success";
	}

	@RequestMapping(value = "sort/{method}", method = RequestMethod.GET)
	public String sort(@PathVariable("method") String method, ModelMap modelMap) {
		if (method.equalsIgnoreCase("ASC")) {
			modelMap.put("invoices", invoiceService.sortByPriceASC());
			return "admin.sort_asc";
		}

		else {
			modelMap.put("invoices", invoiceService.sortByPriceDESC());
			return "admin.sort_desc";
		}
	}

	@RequestMapping(value = "show/detail/{id}", method = RequestMethod.GET)
	public String show_detail_invoice(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("invoice_details", invoiceDetailService.find(id));
		return "admin.show_detail";
	}
}
