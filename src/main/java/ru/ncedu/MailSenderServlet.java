package ru.ncedu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Gorbatovskiy on 02.03.2016.
 */
public class MailSenderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("status", "");
        getServletContext()
                .getRequestDispatcher("/mail.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = "test.ncedu@gmail.com";
        final String password = "test.ncedu1";

        String toEmail = req.getParameter("to");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("test.ncedu@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            req.setAttribute("status", "Complete");
            getServletContext()
                    .getRequestDispatcher("/mail.jsp")
                    .forward(req, resp);

        } catch (MessagingException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    e.getMessage());
        }
    }
}
