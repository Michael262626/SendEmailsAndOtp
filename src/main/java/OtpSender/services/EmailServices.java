package OtpSender.services;

import OtpSender.request.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServices {
    @Autowired
    JavaMailSender javaMailSender;
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    static  String from = "dikandumichael@gmail.com";

    public  void sendEmail(EmailRequest emailRequest){
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(emailRequest.getEmailTo());
        simpleMailMessage.setSubject(Message.registrationMessageSubject());
        simpleMailMessage.setText(Message.registrationMessageBody(emailRequest.getUsername()));
        javaMailSender.send(simpleMailMessage);
    }
}
