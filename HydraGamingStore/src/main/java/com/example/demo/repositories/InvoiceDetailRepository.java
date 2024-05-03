package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.entities.InvoiceDetail;
import com.example.demo.entities.Product;

@Repository("invoiceDetailRepository")
public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail, Integer> {
	@Query(value = "select * from invoice_detail where invoice_id=:id", nativeQuery = true)
	public List<InvoiceDetail> find(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "delete from invoice_detail where invoice_id=:id", nativeQuery = true)
	public void delete_invoice(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "delete from invoice_detail where invoice_id in (select invoice_id from invoice where account_id=:id)", nativeQuery = true)
	public void delete_account_id(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "delete from invoice_detail where invoice_id in (select invoice_id from invoice where account_id=:id)", nativeQuery = true)
	public void delete_invoice_detail_account_id(@Param("id") int id);
}
