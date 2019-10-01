package tools;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class Email {

    private String gUserName = "oleg.gavryljuk@gmail.com";
    private String gPassword = "Oleg2018";

    private String message, subject;
    private String[] attachFiles, address;

    public Email message(String message) {
        this.message = message.toString();
        return this;
    }

    public Email address(String... address) {
        this.address = address;
        return this;
    }

    public Email attachFiles(String... attachFiles) {
        this.attachFiles = attachFiles;
        return this;
    }

    public Email subject(String subject) {
        this.subject = subject;
        return this;
    }

    public void send() {
        if (message != null && address != null && subject != null) {
            // sets SMTP server properties
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.user", gUserName);
            properties.put("mail.password", gPassword);
            // creates a new session with an authenticator
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(gUserName, gPassword);
                }
            };
            Session session = Session.getInstance(properties, auth);
            try {
                // creates a new e-mail message
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(gUserName));
                InternetAddress[] toAddresses = new InternetAddress[address.length];
                for (int i = 0; i < address.length; i++) {
                    toAddresses[i] = new InternetAddress(address[i]);
                }
                msg.setRecipients(Message.RecipientType.TO, toAddresses);
                msg.setSubject(subject);
                // creates message part
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(message, "text/html");
                // creates multi-part
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                // adds attachments
                if (attachFiles != null && attachFiles.length > 0) {
                    for (String filePath : attachFiles) {
                        MimeBodyPart attachPart = new MimeBodyPart();
                        try {
                            attachPart.attachFile(filePath);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        multipart.addBodyPart(attachPart);
                    }
                }
                // sets the multi-part as e-mail's content
                msg.setContent(multipart);
                // sends the e-mail
                Transport.send(msg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } else throw new RuntimeException(">>> Please set all email fields : address, subject, message");
    }
}
