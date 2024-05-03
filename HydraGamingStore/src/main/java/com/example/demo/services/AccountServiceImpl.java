package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;
import com.example.demo.entities.RoleAccount;
import com.example.demo.repositories.AccountRepository;

@Repository("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return accountRepository.login(username, password);
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public int findPoint(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findPoint(username);
	}

	@Override
	public void checkOutByPoint(String username, int point) {
		// TODO Auto-generated method stub
		accountRepository.checkOutByPoint(username, point);
	}

	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public void delete(int id) {
		accountRepository.deleteById(id);

	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return accountRepository.findAll(pageable);
	}

	@Override
	public void delete_account(int id) {
		// TODO Auto-generated method stub
		accountRepository.delete_account(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = this.accountRepository.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("Username not found for " + username);
			
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (RoleAccount role : account.getRoleAccounts()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
		}
		
		return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
	}

	@Override
	public Account findByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username);
	}

	@Override
	public void update(String fullname, java.util.Date birthday, String gender, String username) {
		// TODO Auto-generated method stub
		accountRepository.update(fullname, birthday, gender, username);

	}

}
