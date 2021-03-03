package app.servlets;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class ContactServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        PrintWriter writer = response.getWriter();

        if(!message.equals(null)){
            String host = "smtp.gmail.com";
            int port = 587;
            String username = "marina.lobko@gmail.com";
            String password = "svadba23072011";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            Session session = Session.getDefaultInstance(props, null);

            String body = message;

            try {
                MimeMessage m = new MimeMessage(session);
                m.setSubject(name);
                m.setFrom(new InternetAddress(email, null));
                m.setText(body);
                m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(username, "me"));


                Transport transport = session.getTransport("smtp");
                transport.connect(host, port, username, password);

                Transport.send(m);

            } catch (AddressException e) {
                e.printStackTrace();
            } catch (javax.mail.MessagingException e) {
                e.printStackTrace();
            }


            try {
                writer.println("Message send!");
            } finally {
                writer.close();
            }

        }
    }
}
