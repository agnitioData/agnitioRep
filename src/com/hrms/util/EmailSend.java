/**
 * 
 */
package com.hrms.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Rishabh Porwal
 * this class is responsible to send mail at the time of leave apply
 */
public class EmailSend {
	
	public static void sendEmail(final String userName, final String password, List<String> toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
		String host= "smtp3.netcore.co.in";
		String port = "587";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        String toAdd = "";
        List<String> reciepents = new  ArrayList<String>();
        Iterator<String> allUsersDOBIterator = toAddress.iterator();
        InternetAddress[] toAddresses = new InternetAddress[toAddress.size()];
        int i = 0;
		while(allUsersDOBIterator.hasNext())
	    {
			toAdd = allUsersDOBIterator.next();
			toAddresses[i++] = new InternetAddress(toAdd);
		}
		
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		
        msg.setFrom(new InternetAddress(userName));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
 
        // sends the e-mail
        Transport.send(msg);
        System.out.println("Sent message successfully....");
    }
	
}
