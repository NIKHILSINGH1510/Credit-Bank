package guiproject11;

import static guiproject11.JavaMailUtil.mail;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



class JavaMailUtil {
    static String mail;
    public static void Connection() {
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_bank?autoReconnect=true&useSSL=false", "root", "root");

                searchid ob = new searchid();
                String ID = ob.id;
                System.out.println(ID);
                PreparedStatement ps =  conn.prepareStatement("Select * from studentcredit where Id="+ID);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                mail = "You have "+rs.getString("TotalCredit")+" credits till now and your current eligible degree type is "+rs.getString("TypeOfDegree")+". Credits required for next degree "+rs.getString("CreditRequired");
            }
            catch(Exception e2)
            {
                System.out.println(e2);
            }   
    }
    public static void sendMail(String recepient) throws Exception {
//        System.out.println("Preparing to send mail");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myEmail = "deepakparihar******@gmail.com";
        String password = "*********";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        
        Message msg = prepareMessage(session, myEmail, recepient);
        
        Transport.send(msg);
        System.out.println("Message sent Succesfully");
    }
    
    private static Message prepareMessage(Session session, String myEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Academics");
            message.setText(mail);
            return message;
        }
        catch (Exception ex) {
//            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
        }
        return null;
    }
}

public class SendMail {
    
    static String MailID;
    public static void Connect() {
        
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/credit_bank?autoReconnect=true&useSSL=false", "root", "root");

                searchid ob = new searchid();
                String ID = ob.id;
//                System.out.println(ID);
                PreparedStatement ps =  conn.prepareStatement("Select * from studentinformation where Id="+ID);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                MailID = rs.getString("Email");
                }
            catch(Exception e2)
            {
                System.out.println(e2);
            }   
    }
    
    public static void main(String[] args) throws Exception{
        JavaMailUtil ob = new JavaMailUtil();
        ob.Connection();
        Connect();
        JavaMailUtil.sendMail(MailID);
        return;
    }
}