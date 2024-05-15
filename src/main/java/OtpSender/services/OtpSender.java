package OtpSender.services;

import OtpSender.request.OtpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

@Service
public class OtpSender {
    @Autowired
    private JavaMailSender javaMailSender;
    public String generateOtp() {
        Random random = new Random();
        int otpLength = 4;
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
    public void sendOtp(OtpRequest otpRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(otpRequest.getEmail());
        message.setSubject("Your one time Otp");
        message.setText("Your otp is"+generateOtp());
        javaMailSender.send(message);
    }
}

