package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.demo.paypal.PayPalConfig;

@Service("payPalService")
public class PayPalServiceImpl implements PayPalService {
	@Autowired
	private Environment environment;

	@Override
	public PayPalConfig getPayPalConfig() {
		PayPalConfig payPalConfig = new PayPalConfig();
		payPalConfig.setAuthToken(environment.getProperty("paypal.authtoken"));
		payPalConfig.setPosturl(environment.getProperty("paypal.posturl"));
		payPalConfig.setBusiness(environment.getProperty("paypal.business"));
		payPalConfig.setReturnurl(environment.getProperty("paypal.returnurl"));
		return payPalConfig;
	}

}
