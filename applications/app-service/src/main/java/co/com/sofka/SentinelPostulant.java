package co.com.sofka;

import co.com.sofka.usecase.postulantusecase.findwhostartstoday.FindWhoStartsTodayUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.UUID;


@EnableScheduling
@Component
@RequiredArgsConstructor
public class SentinelPostulant implements CommandLineRunner {

    @Autowired
    private JavaMailSender emailSender;
    private final FindWhoStartsTodayUseCase findWhoStartsTodayUseCase;

    @Scheduled(cron = "* * * * * ?")
    public Mono<Void> verifyOnHOurEspecify() throws Exception {
        System.out.println("A UNA HORA ESPECIFICA");

        var now = LocalDate.now();
        try{
            String year = String.valueOf(now.getYear());
            String month = String.valueOf(now.getMonthValue());
            if (month.length() == 1){
                month = "0" + month;
            }
            String day = String.valueOf(now.getDayOfMonth());
            if (day.length() == 1){
                day = "0" + day;
            }
            String today = year +"-"+ month +"-"+ day;
            var emails = findWhoStartsTodayUseCase.findWhoStartToday("2022-08-09").collectList().block();
            System.out.println(emails);
            System.out.println(today);

            run("pealveco@gmail.com", "pealveco@yahoo.com");
        } catch (DateTimeParseException dateTimeParseException){
            System.out.println("ERRRORRRRRRRRRR");
        }
        return Mono.empty();
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args).forEach(s -> {
            var bodyMessage = "EJEMPLO DE MENSAJE POR CORREO ELECTRONICO ID = " + UUID.randomUUID().toString();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sofkaprueba111@gmail.com");
            message.setTo(s);
            message.setSubject("Mensaje de PRUEBA. Soy PITER!!!!!!!");
            message.setText(bodyMessage);
            emailSender.send(message);
        });
    }
}
