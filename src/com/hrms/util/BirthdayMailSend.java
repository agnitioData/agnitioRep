package com.hrms.util;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @author Rishabh Porwal
 * this class is responsible to send bday wishes mail.
 *
 */

public class BirthdayMailSend {
	
	public String sendMail(String recipient){
		
		final String username = "himanshu.mishra@agnitio-technologies.com";
	    final String password = "Chunky@23";
      
	    // Recipient's email ID needs to be mentioned.
	    String to = recipient;
      
	    // Sender's email ID needs to be mentioned
	    String from = "himanshu.mishra@agnitio-technologies.com";
      
	    // Get system properties
	    Properties properties = System.getProperties();
	    
      // Setup mail server
      properties.put("mail.smtp.starttls.enable", "true"); 
      properties.put("mail.smtp.host", "smtp3.netcore.co.in");
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.auth", "true");
      
      // Get the default Session object.
      Session session = Session.getInstance(properties,
  	        new javax.mail.Authenticator() {
  	            protected PasswordAuthentication getPasswordAuthentication() {
  	                return new PasswordAuthentication(username, password);
  	            }
  	        });
     
      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         // Set Subject: header field
         message.setSubject("Happy Birthday Dear!");
         // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();
         // Fill the message
         messageBodyPart.setText("May your birthday and every day be filled with the warmth of sunshine, "
	        		+ "the happiness of smiles, the sounds of laughter, the feeling of love and the sharing of good cheer!");
         // Create a multipar message
         Multipart multipart = new MimeMultipart();
         // Set text message part
         multipart.addBodyPart(messageBodyPart);
         
         // Part two is attachment
        /* messageBodyPart = new MimeBodyPart();
         String filename = "file.txt";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);*/
         //multipart.addBodyPart(messageBodyPart);
         // Send the complete message parts
         message.setContent(multipart );
         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (Exception mex) {
         mex.printStackTrace();
      }
		
		
	    
		return "Success";
		
	}

}
