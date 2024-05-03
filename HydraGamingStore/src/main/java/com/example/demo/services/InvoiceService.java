package com.example.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;

public interface InvoiceService {

	public void save(Invoice invoice);

	public Iterable<Invoice> findAll();

	public void delete(int id);

	public List<Invoice> sortByPriceASC();

	public List<Invoice> sortByPriceDESC();

	Page<Invoice> findAll(Pageable pageable);

	public void delete_invoice_account_id(int id);
}
