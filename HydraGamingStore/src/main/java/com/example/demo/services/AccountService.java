package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entities.Account;

public interface AccountService extends UserDetailsService {
	public Account login(String username, String password);

	public Account save(Account account);

	public int findPoint(String username);

	public void checkOutByPoint(String username, int point);

	public Iterable<Account> findAll();

	public void delete(int id);

	public Page<Account> findAll(Pageable pageable);

	public void delete_account(int id);
	
	public Account findByUsername(String username);
	
	public void update(String fullname, java.util.Date birthday, String gender, String username);
}
