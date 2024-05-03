package com.example.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Account;
import com.example.demo.entities.Invoice;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.InvoiceRepository;

@Repository("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public void save(Invoice invoice) {
		// TODO Auto-generated method stub
		invoiceRepository.save(invoice);

	}

	@Override
	public Iterable<Invoice> findAll() {
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		invoiceRepository.deleteById(id);
	}

	@Override
	public List<Invoice> sortByPriceASC() {
		// TODO Auto-generated method stub
		return invoiceRepository.sortByPriceASC();
	}

	@Override
	public List<Invoice> sortByPriceDESC() {
		// TODO Auto-generated method stub
		return invoiceRepository.sortByPriceDESC();
	}

	@Override
	public Page<Invoice> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return invoiceRepository.findAll(pageable);
	}

	@Override
	public void delete_invoice_account_id(int id) {
		// TODO Auto-generated method stub
		invoiceRepository.delete_invoice_account_id(id);
	}

}
