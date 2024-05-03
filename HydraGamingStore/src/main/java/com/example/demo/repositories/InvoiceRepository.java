package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.entities.Product;

@Repository("invoiceRepository")
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
	@Query("from Invoice order by invoiceTotal ASC")
	public List<Invoice> sortByPriceASC();

	@Query("from Invoice order by invoiceTotal DESC")
	public List<Invoice> sortByPriceDESC();

	@Query(value = "select * from invoice", nativeQuery = true)
	Page<Invoice> findAll(Pageable pageable);

	@Modifying
	@Transactional
	@Query(value = "delete from invoice where account_id =:id ", nativeQuery = true)
	public void delete_invoice_account_id(@Param("id") int id);
}
