package co.com.sofka.usecase.postulantusecase.findwhostartstoday;



import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@RequiredArgsConstructor
public class FindWhoStartsTodayUseCase {
    private final PostulantRepository postulantRepository;

    public Flux<String> findWhoStartToday(String date){

        return postulantRepository.findWhoStart(date); /*findAll()
                .filter(postulant2 -> postulant2.getChallenge().getInitialDate().equals(newDate))
                .map(Postulant::getEmail);*/


        // var emails =postulantRepository.findAll().map( postulant -> postulant.getEmail());
        //return postulantRepository.findAll();
        /*return postulantRepository.findWhoStart((Flux<String>) emails);*/

    }
}
