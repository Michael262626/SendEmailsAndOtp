package OtpSender.data.repository;

import OtpSender.data.model.Register;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Emails extends MongoRepository<Register, String> {
}
