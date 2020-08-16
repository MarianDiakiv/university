package com.marian.university.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public void sendEmail(String email, String text){
        String username = "mariandiakiv@gmail.com";
        String password = "marian5456801";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mariandiakiv@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email) // адреса отримувача
            );
            message.setSubject("Повідомлення про запис на урок");
            message.setText(text);

            Transport.send(message);

//            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
