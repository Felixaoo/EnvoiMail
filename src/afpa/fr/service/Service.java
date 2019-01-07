package afpa.fr.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;





public class Service {

	public boolean readId(String login, String mdp) throws IOException {
		boolean valid =true;
		FileReader fr= new FileReader("c:\\ENV\\connexion.txt");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String[]tab = br.readLine().split(":");
			if("login".equals(tab[0])) {
				if(!login.equals(tab[1])) {
					valid = false;

				}

			}
			else if ("mdp".equals(tab[0])) {
				if (!mdp.equals(tab[1])) {
					valid=false;
				}
			}

		}
		br.close();
		return valid;

	}
	
	public void sendMail(String adresse, String objet, String body) throws Throwable, Exception {
		String from = "idpjava2019@gmail.com";
		String password = "@Afpa2019";
		String to = adresse;

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(objet);
		//message.setText("Bonjour, vous trouverez en pièce jointe la facture de Caisse du " + fileCreatedName.substring(27, 35));


        Multipart multipart = new MimeMultipart();       
        BodyPart messageBodyPart = new MimeBodyPart();     
        messageBodyPart.setText(body);
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);

		
		
		
		Transport.send(message);
	}
}