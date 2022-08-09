package co.com.sofka.usecase.postulantusecase.findwhostartstoday;


import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


import java.time.LocalDate;

@RequiredArgsConstructor
public class FindWhoStartsTodayUseCase {
    private final PostulantRepository postulantRepository;

    public Flux<String> findWhoStartToday(LocalDate date){
        return postulantRepository.findAll()
                .filter(postulant -> postulant.getChallenge().getInitialDate().equals(date))
                .map(postulant -> postulant.getEmail());
    }
}
