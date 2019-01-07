package afpa.fr.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		boolean valid =false;
		FileReader fr= new FileReader("c:\\ENV\\connexion.txt");
		BufferedReader br = new BufferedReader(fr);
		while(br.ready()) {
			String[]tab = br.readLine().split(";");
			if("login".equals(tab[0])&& login.equals(tab[1])) {
					valid = true;


			}
			else if ("mdp".equals(tab[0]) && mdp.equals(tab[1])) {
					valid=true;
				
			}

		}
		br.close();
		return valid;

	}
	
	public void ecrireFichier(String login, String mdp, String nom, String prenom, String tel, String mail) throws IOException {
		FileWriter fw = new FileWriter("c:\\ENV\\clients.txt", true);
		BufferedWriter bw = new BufferedWriter (fw);
		bw.write(login+";"+mdp+";"+nom+";"+prenom+";"+tel+";"+mail);
		bw.newLine();
		bw.close();
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