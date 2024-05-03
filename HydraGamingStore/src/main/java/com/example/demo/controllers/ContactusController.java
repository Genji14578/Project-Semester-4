package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entities.Item;
import com.sun.xml.messaging.saaj.packaging.mime.internet.MimeMultipart;

@Controller
@RequestMapping(value= {"contactus"} ) // Controller mac dinh
public class ContactusController {
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest httpServletRequest)
			throws AddressException, MessagingException, IOException {

		return "contactus.index"; // tiles.xml

	}

	@RequestMapping(value = "sendMail", method = RequestMethod.POST)
	public String sendMail(HttpServletRequest httpServletRequest, ModelMap modelMap) {
		try {
			sendmail(httpServletRequest);
			modelMap.put("msg", "sendMailSuccessful");
			return "contactus.index";
		} catch (Exception e) {
			modelMap.put("msg", "sendMailUnsuccessful");
			return "contactus.index";
		}

	}

	private void sendmail(HttpServletRequest httpServletRequest)
			throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		String username = (String) httpServletRequest.getParameter("userEmail");
		String password = (String) httpServletRequest.getParameter("userPassword");
		String content = (String) httpServletRequest.getParameter("userContent");
		String subject = (String) httpServletRequest.getParameter("userSubject");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username, false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("hydragamingstore@gmail.com"));
		msg.setSubject(subject);
		msg.setContent(content, "text/html");

		Transport.send(msg);
	}
}