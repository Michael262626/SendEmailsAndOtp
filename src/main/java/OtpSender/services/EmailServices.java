package OtpSender.services;

import OtpSender.request.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServices {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(EmailRequest emailRequest){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailRequest.getEmailTo());
        simpleMailMessage.setSubject(emailRequest.getEmailSubject());
        simpleMailMessage.setText(emailRequest.getBody());
        javaMailSender.send(simpleMailMessage);
    }
}
