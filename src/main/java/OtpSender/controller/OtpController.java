package OtpSender.controller;

import OtpSender.request.EmailRequest;
import OtpSender.request.OtpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import OtpSender.response.ApiResponse;
import OtpSender.services.EmailServices;
import OtpSender.services.OtpSender;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("otp/Api")
public class OtpController {
    @Autowired
    private OtpSender otpSender;
    @Autowired
    private EmailServices emailServices;
    @PostMapping("send/otp")
    public ResponseEntity<?> sendOtp(@RequestBody OtpRequest otpRequest){
        try{
            otpSender.sendOtp(otpRequest);
        return new ResponseEntity<>(new ApiResponse("Sent Successfully",true), CREATED);
    }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(e.getMessage(),false), BAD_REQUEST);
        }
    }
    @PostMapping("send/emails")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){
        try{
            emailServices.sendEmail(emailRequest);
            return new ResponseEntity<>(new ApiResponse("Sent Successfully",true), CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(e.getMessage(),false), BAD_REQUEST);
        }
    }
}
