package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.entities.InvoiceDetail;

public interface InvoiceDetailService {

	public void save(InvoiceDetail invoiceDetail);

	public Iterable<InvoiceDetail> findAll();

	public List<InvoiceDetail> find(int id);

	public void delete_invoice(int id);

	public void delete_invoice_detail_account_id(int id);
}
