package co.com.sofka;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@EnableScheduling
@Component
public class SentinelPostulant {
    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long HORA = MINUTO * 60;
    private final long DIA = HORA * 24;

    @Scheduled(fixedDelay = SEGUNDO)
    public Mono<Void> verifayBySecond(){
        System.out.println("Por segundo");
        return Mono.empty();
    }

    @Scheduled(fixedDelay = MINUTO)
    public Mono<Void> verifayByMinute(){
        System.out.println("Por minutooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        return Mono.empty();
    }
}
