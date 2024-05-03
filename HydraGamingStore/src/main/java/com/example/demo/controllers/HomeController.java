package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Account;
import com.example.demo.entities.Product;
import com.example.demo.entities.Role;
import com.example.demo.entities.RoleAccount;
import com.example.demo.entities.RoleAccountId;
import com.example.demo.services.AccountService;
import com.example.demo.services.ProductService;

@Controller
@RequestMapping(value = { "", "home" }) // Controller mac dinh
public class HomeController {
	@Autowired
	private ProductService productService;

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		loadData(modelMap);
		return "home.index";

	}

	public void loadData(ModelMap modelMap) {
		List<Product> products1 = productService.findByLastestAndCategory(6, 1);
		List<Product> products2 = productService.findByLastestAndCategory(6, 2);
		List<Product> products3 = productService.findByLastestAndCategory(6, 3);

		modelMap.put("products1", products1);
		modelMap.put("products2", products2);
		modelMap.put("products3", products3);

	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, ModelMap modelMap,
			HttpServletRequest httpServletRequest) {
		loadData(modelMap);
		if (error != null) {
			System.out.println("Error");
			modelMap.put("msg", "errLogin");
		}

		if (logout != null) {
			modelMap.put("msg", "successLogout");
		}
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountService.findByUsername(auth.getName());
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("account", account);
		return "home.index";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home/login?logout";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(HttpServletRequest httpServletRequest, ModelMap modelMap) throws ParseException {
		try {
			Account account = accountService
					.findByUsername(String.valueOf(httpServletRequest.getParameter("username")));
			if (account == null) {
				HttpSession session = httpServletRequest.getSession();
				loadData(modelMap);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
				BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
				String username = httpServletRequest.getParameter("username");
				String password = bCrypt.encode(httpServletRequest.getParameter("password"));
				String fullname = httpServletRequest.getParameter("fullname");
				String gender = httpServletRequest.getParameter("gender");
				String bdate = httpServletRequest.getParameter("birthday");
				Date birthday = simpleDateFormat.parse(bdate);

				account = new Account(username, password, fullname, gender, birthday, new Date(), 0);
				accountService.save(account);
				session.setAttribute("account", account);
				modelMap.put("msg", "successRegister");
				return "home.index";
			} else {
				modelMap.put("msg", "alreadyhaveAccount");
				loadData(modelMap);
				return "home.index";
			}

		} catch (Exception e) {
			modelMap.put("msg", "errRegister");
			loadData(modelMap);
			return "home.index";
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest httpServletRequest, ModelMap modelMap) throws ParseException {
		try {
			HttpSession session = httpServletRequest.getSession();
			Account account = (Account) session.getAttribute("account");
			if (account != null) {

				loadData(modelMap);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fullname = httpServletRequest.getParameter("fullname");

				String gender = httpServletRequest.getParameter("gender");
				String bdate = httpServletRequest.getParameter("birthday");
				Date birthday = simpleDateFormat.parse(bdate);
				account.setFullname(fullname);
				account.setBirthday(birthday);
				account.setGender(gender);
				accountService.update(fullname, birthday, gender, account.getUsername());
				session.setAttribute("account", account);

				modelMap.put("msg", "successEdit");
				return "home.index";
			} else {

				loadData(modelMap);
				return "home.index";
			}

		} catch (Exception e) {
			modelMap.put("msg", "errEdit");

			loadData(modelMap);
			return "home.index";
		}
	}
	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied() {
		return "templates/accessdenied";
	}
}