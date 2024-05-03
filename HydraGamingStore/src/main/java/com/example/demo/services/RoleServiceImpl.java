package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.RoleRepository;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void delete_role_account_id(int id) {
		// TODO Auto-generated method stub
		roleRepository.delte_role_account_id(id);
	}

}
