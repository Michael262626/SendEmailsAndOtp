package OtpSender.services;

public class Message {
    public static String registrationMessageBody(String username){
        return """
                Hi %s,
                this is your one time otp code please keep this safe and use immediately. 
                """.formatted(username);
    }

    public static String registrationMessageSubject() {
        return "Your one time Otp";
    }
}
