package com.spring.boot.service;

import java.io.File;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.spring.boot.bean.Mail;

@Service("mailService")
public class MailServiceImpl implements MailService {

   @Autowired
   JavaMailSender mailSender;

   public void sendEmail(Mail mail) {
       MimeMessage mimeMessage = mailSender.createMimeMessage();

       try {

           MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

           mimeMessageHelper.setSubject(mail.getMailSubject());
           /*change it bacj*/
           mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "Sai Kumar T"));
           mimeMessageHelper.setTo(mail.getMailTo());
           mimeMessageHelper.setText(mail.getMailContent());
           
			
			  FileSystemResource file=new FileSystemResource(new File("D:/Sai Kumar_Java_Resume.docx"));
			  mimeMessageHelper.addAttachment("Sai Kumar_Java_Resume.docx", file);
			 
           
           mailSender.send(mimeMessageHelper.getMimeMessage());

       } catch (MessagingException e) {
           e.printStackTrace();
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
   }


}
