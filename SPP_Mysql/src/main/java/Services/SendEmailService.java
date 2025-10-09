package Services;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class SendEmailService {

    public static void sendPlain(
      String host, int port,
      String user, String pass,
      String to, String subject, String body
  ) throws MessagingException {

    Properties p = new Properties();
    p.put("mail.smtp.auth", "true");
    p.put("mail.smtp.starttls.enable", "true");
    p.put("mail.smtp.host", host);
    p.put("mail.smtp.port", String.valueOf(port));
    p.put("mail.smtp.ssl.trust", host);
    p.put("mail.smtp.ssl.protocols", "TLSv1.2");

    Session session = Session.getInstance(p, new Authenticator() {
      @Override protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pass);
      }
    });

    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(user));
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
    msg.setSubject(subject);
    msg.setContent(body, "text/html; charset=utf-8");

    Transport.send(msg);
  }

}
