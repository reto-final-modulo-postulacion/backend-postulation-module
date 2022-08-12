package co.com.sofka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class SimpleMail {
    private String from;
    private String to;
    private String subject;
    private String message;
    @Autowired
    private JavaMailSender mailSender;

    public Mono<Void> sendMe(){
        SimpleMailMessage message = new SimpleMailMessage();
        mailSender.send(message);
        return Mono.empty();
    }
}
