package com.spring.boot;



import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.boot.bean.Mail;
import com.spring.boot.service.MailService;


@SpringBootApplication
@ComponentScan(basePackages = {
	    "com.spring"
	})
public class SpringMailApplication {

	
	public static void main(String[] args) {
		String[] mailAddress= {
			"Hari@prophecyconsulting.com"	
		};
		 ApplicationContext ctx = SpringApplication.run(SpringMailApplication.class, args);
		for(int i=0;i<mailAddress.length;i++) {
		Mail mail = new Mail();
        mail.setMailFrom("tsaikumar557@gmail.com");
        mail.setMailTo(mailAddress[i]);
        mail.setMailSubject("Full Stack Java Developer");
		  mail.setMailContent("Hello,\n\nHope this email finds you well. I wanted to reach out because I’m currently exploring new opportunities in C2C Roles.\nI’ve been working professionally as a Software Developer for 7 years and I’m ready for my next challenge.\n\nIf you have time, I’d love to talk about whether my background would make me a fit for any openings you have.\n\nHere I am attaching my resume with this email for your reference. You can go through it and get back to me for further discussion.\nLinked in Profile : www.linkedin.com/in/sai-kumar-dev\nI look forward to hearing from you.\n\nThanks and Regards\nSai Kumar\n757-632-0148");
        MailService mailService = (MailService) ctx.getBean("mailService");
        //MimeMessage message =mailService.
        mailService.sendEmail(mail);
        
		}
	}

}
