package co.com.sofka.usecase.postulantusecase.calculateage;


import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
public class CalculateAgeUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Integer> calculateAge(String id){
        return postulantRepository.findById(id)
                .map(postulant -> {
                    var age = LocalDate.now().getYear() - postulant.getDateOfBirth().getYear();
                    return age;
                });
    }
}
