package application;

import java.io.IOException;
import java.util.Properties;

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
import javax.swing.JOptionPane;

public class Email {
	
	private static String body = checkList.emailStr;
	private static String path = checkList.path;
	
	public static void main(String[] args) {
		
		final String username = "retificaBrasilOs@gmail.com";
		final String password = "135013505342bB";
		String fromEmail = "retificaBrasilOs@gmail.com";
		String toEmail = checkList.emailDoClienteStr;
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Detalhes do Orçamento");
			
			Multipart emailContent = new MimeMultipart();

			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(body);

			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.attachFile(path);
			
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			msg.setContent(emailContent);
			
			Transport.send(msg);
			
			System.out.println("Mensagem enviada com sucesso");
			aguardeEmail.close();
			JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "Finalizado", 1);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}