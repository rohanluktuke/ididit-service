package ididit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService implements ApplicationRunner {

	@Autowired
	private MailService client;
	
	@Autowired
	private MailContentBuilder contentBuilder;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Sending message ...");
		client.prepareAndSend("test@test.com", contentBuilder.build("Rohan"));
	}
	
}
