package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailManager 
{
	@Autowired
	  JavaMailSender mail;
	  public String sendEmail(String fromemail,String toemail,String subject,String text)
	  {
	    try
	    {
	    SimpleMailMessage smm=new SimpleMailMessage();
	    smm.setFrom(fromemail);
	    smm.setTo(toemail);
	    smm.setSubject(subject);
	    smm.setText(text);
	    mail.send(smm);
	    System.out.println("email sent Successfully");
	    return "email sent Successfully";
	    }
	    catch (Exception e) 
	    {
	      return e.getMessage();
	    }

}
}
