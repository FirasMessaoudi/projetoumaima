package com.pds.demo.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class SendMail {
	

	    private final JavaMailSender emailSender;

	    private final SpringTemplateEngine templateEngine;

	public SendMail(JavaMailSender emailSender, SpringTemplateEngine templateEngine) {
		this.emailSender = emailSender;
		this.templateEngine = templateEngine;
	}


	@Async
	public void sendSimpleMessage(Mail mail,String path,String sender) throws MessagingException, IOException {
	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message,
	                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                StandardCharsets.UTF_8.name());

	      //helper.addAttachment("tn.png", new ClassPathResource("/images/tn.png"));
	     	DataSource dataSource = new FileDataSource(path);
	     	String name;
	     	if(path.indexOf(".pdf")!=-1){
	     		 name="CV.pdf";
			}else {
	     		name = "CV.docx";
			}
	    	helper.addAttachment(name, dataSource);
	        Context context = new Context();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("text", "Vous avez une demande de candidature de la part de "+sender);
		model.put("message", "Veuillez trouvez son cv ci-joint");
		mail.setModel(model);
	        context.setVariables(mail.getModel());
	        String html = templateEngine.process("email-template", context);
	        helper.setTo(mail.getTo());
	        helper.setText(html, true);
	        helper.setSubject(mail.getSubject());
	        helper.setFrom(mail.getFrom());

	        emailSender.send(message);
	    }

	}
