package com.example.demo.paypal;

import javax.servlet.http.*;

public class PayPalConfig {

    private String authToken;
    private String posturl;
    private String business;
    private String returnurl;
    private String cancelurl;
    private String cmd;

    public String getAuthToken() {
        return authToken;
    }

    public String getPosturl() {
        return posturl;
    }

    public String getBusiness() {
        return business;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public String getCancelurl() {
        return cancelurl;
    }

    public String getCmd() {
        return cmd;
    }

    public PayPalConfig getConfig(HttpServletRequest request) {
        PayPalConfig pc = new PayPalConfig();
        try {        	
            pc.authToken = "vjfkK0m5OTxuXXrSzuEv7uncWgGQQB94xogYNq6A1kaSF4ZyGQ95Wpn";
            pc.posturl = "https://www.sandbox.paypal.com/cgi-bin/webscr";
            pc.business = "sb-hsnyz669274@business.example.comm";
            pc.returnurl = "http://localhost:9596/cart/action=checkout?payment=Paypal";
            
        } catch (Exception ex) {
            pc = null;
        }
        return pc;
    }

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setPosturl(String posturl) {
		this.posturl = posturl;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}

	public void setCancelurl(String cancelurl) {
		this.cancelurl = cancelurl;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
}
