package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Role;

@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Integer> {
	@Modifying
	@Transactional
	@Query(value = "delete from role_account where account_id =:id", nativeQuery = true)
	public void delte_role_account_id(@Param("id") int id);
}
