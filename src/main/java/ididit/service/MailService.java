package ididit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private JavaMailSender mailSender;
	
	@Autowired
	public MailService (JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void prepareAndSend(String recipient, String message) {
		
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("rohanluktuke@gmail.com");
			messageHelper.setTo(recipient);
			messageHelper.setSubject("Time to post your accomplishments!");
			messageHelper.setText(message, true);
		};
		
		mailSender.send(messagePreparator);
		
		
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setTo(recipient);
//		mailMessage.setFrom("rohanluktuke@gmail.com");
//		mailMessage.setSubject("Test send from Rohan");
//		mailMessage.setText(message);
//		mailSender.send(mailMessage);
		
	}
}
