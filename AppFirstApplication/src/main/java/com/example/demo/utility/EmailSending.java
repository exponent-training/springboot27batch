package com.example.demo.utility;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Incident;

@Component
public class EmailSending {

	@Autowired
	private JavaMailSender javaMailSender;

	public void incidentCreateMailSend(Incident incident) {
		//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//		simpleMailMessage.setTo("ajasshaikh8390@gmail.com");
		//		simpleMailMessage.setSubject("INCIDENT CREATED SUCCESSFULLY.");
				String str = "<html>\r\n" + 
						"\r\n" + 
						"<body style='backgroung-color:grey'> \r\n" + 
						"<table cellpadding=\"0\" cellspacing=\"0\" width=\"640\" align=\"center\" border=\"1\">     \r\n" + 
						"<tr>         \r\n" + 
						"<td>            \r\n" + 
						"<table cellpadding=\"0\" cellspacing=\"0\" width=\"318\" align=\"left\" border=\"1\">                 \r\n" + 
						"<tr>                     \r\n" + 
						"<td>Incident Number</td>                 \r\n" + 
						"</tr>             \r\n" + 
						"</table>             \r\n" + 
						"<table cellpadding=\"0\" cellspacing=\"0\" width=\"318\" align=\"left\" border=\"1\">                 \r\n" + 
						"<tr>                    \r\n" + 
						"<td>"+incident.getIncidentnumber()+"</td>                 \r\n" + 
						"</tr>             \r\n" + 
						"</table>                           \r\n" + 
						"</td>     \r\n" + 
						"</tr> \r\n" + 
						"</table> \r\n" + 
						"</body>\r\n" + 
						"\r\n" + 
						"</html>";
		//		simpleMailMessage.setText(str);
		//		
		//		javaMailSender.send(simpleMailMessage);


		try {
			MimeMessage msg = javaMailSender.createMimeMessage();

			// true = multipart message
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);

			helper.setTo("ajasshaikh8390@gmail.com");

			helper.setSubject("Testing from Spring Boot.");

			// default = text/plain
			//helper.setText("Check attachment for image!");

			// true = text/html

			helper.setText(str, true);

			javaMailSender.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
