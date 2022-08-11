package co.com.sofka;

import co.com.sofka.usecase.postulantusecase.findwhostartstoday.FindWhoStartsTodayUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


import javax.mail.MailSessionDefinition;
import java.time.LocalDate;


@EnableScheduling
@Component
@RequiredArgsConstructor
public class SentinelPostulant {
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;
    private final long DIA = HORA * 24;
    private MailSessionDefinition sessionDefinition;
    private final FindWhoStartsTodayUseCase findWhoStartsTodayUseCase;

    /*@Scheduled(fixedDelay = SEGUNDO)
    public Mono<Void> verifayBySecond(){
        System.out.println("Por segundo");
        return Mono.empty();
    }

    @Scheduled(fixedDelay = MINUTO)
    public Mono<Void> verifayByMinute(){
        System.out.println("Por minutooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        return Mono.empty();
    }*/

    @Scheduled(cron = "0 28 0 10 * ?")
    public Mono<Void> verifyOnHOurEspecify(){
        System.out.println("A UNA HORA ESPECIFICA");
        //var valor = findWhoStartsTodayUseCase.findWhoStartToday(LocalDate.now()).toStream().collect(Collectors.toList());
        var now = LocalDate.now();
        var x = findWhoStartsTodayUseCase.findWhoStartToday("2022-08-13").collectList().block();
        System.out.println(x);



        //valor.forEach(System.out::println);
        //System.out.println(emails);
       /* if (!emails.equals(null)){
            System.out.println(emails);
        } else {
            System.out.println("NULL!!!!!!!");
        }*/
        /*collect(Collectors.toList())*/
        return Mono.empty();
    }
}
