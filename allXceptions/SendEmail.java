package allXceptions;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendEmail {

public static void SendMail(String recepient)
{
	System.out.println("Sending the message, please wait...");
	Properties properties = new Properties();
	properties.put("mail.smtp.auth","true");
	properties.put("mail.smtp.starttls.enable","true");
	properties.put("mail.smtp.host","smtp.gmail.com");
	properties.put("mail.smtp.port","587");
	
	
	String accountId = "anisingh1999bkao@gmail.com";
	String password = "*********";
	
	Session session = Session.getInstance(properties, new Authenticator(){
		protected  PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(accountId,password);
		}
	});
	
	
	Message message = perpareMessage(session,accountId, recepient);
	try {
		Transport.send(message);
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Message sent!");
}

private static Message perpareMessage(Session session, String accountId, String recepient) {
	// TODO Auto-generated method stub
	try {
	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress(accountId));
	message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
	message.setSubject("tryMessage");
	message.setText("Yo!!");
	return message;
	} catch (AddressException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
	
	
	
	
}