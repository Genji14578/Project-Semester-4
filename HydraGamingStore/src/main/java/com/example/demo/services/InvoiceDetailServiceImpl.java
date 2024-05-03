package com.example.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.entities.InvoiceDetail;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.InvoiceDetailRepository;
import com.example.demo.repositories.InvoiceRepository;

@Repository("invoiceDeatilService")
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;

	@Override
	public void save(InvoiceDetail invoiceDetail) {
		// TODO Auto-generated method stub
		invoiceDetailRepository.save(invoiceDetail);

	}

	@Override
	public Iterable<InvoiceDetail> findAll() {
		// TODO Auto-generated method stub
		return invoiceDetailRepository.findAll();
	}

	@Override
	public List<InvoiceDetail> find(int id) {
		// TODO Auto-generated method stub
		return invoiceDetailRepository.find(id);
	}

	@Override
	public void delete_invoice(int id) {
		// TODO Auto-generated method stub
		invoiceDetailRepository.delete_invoice(id);
	}

	@Override
	public void delete_invoice_detail_account_id(int id) {
		// TODO Auto-generated method stub
		invoiceDetailRepository.delete_invoice_detail_account_id(id);
	}

}
