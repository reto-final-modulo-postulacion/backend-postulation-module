package co.com.sofka.usecase.postulantusecase.registertotraining;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import co.com.sofka.usecase.postulantusecase.addchallenge.AddChallengeUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class RegisterToTrainingUseCase {
    private final PostulantRepository postulantRepository;
    private final AddChallengeUseCase addChallengeUseCase;

    public Mono<Postulant> registerToTraining(String idTraining, String idPostulant){

        return postulantRepository.findById(idPostulant)
                .map(postulant -> {
                    addChallengeUseCase.addChallenge(postulant.getId());
                    postulant.setIdTraining(idTraining);
                    return postulant;
                }).flatMap(postulant -> postulantRepository.update(idPostulant, postulant));
    }
}
