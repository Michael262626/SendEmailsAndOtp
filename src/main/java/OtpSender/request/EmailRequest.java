package OtpSender.request;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailTo;
    private String username;
}
