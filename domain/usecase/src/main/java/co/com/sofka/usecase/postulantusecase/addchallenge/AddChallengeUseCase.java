package co.com.sofka.usecase.postulantusecase.addchallenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.ChallengePostulant;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class AddChallengeUseCase {
    private final PostulantRepository postulantRepository;
    private final ChallengeRepository challengeRepository;

    public Mono<Postulant> addChallenge(String idPostulant/*, String idChallenge*/){
        return postulantRepository.findById(idPostulant)
                .map(postulant -> {
                    var x = challengeRepository.findAll().map(challenge -> challenge.getId()).toStream().collect(Collectors.toList());
                    Collections.shuffle(x);
                    var newChallenge = new ChallengePostulant(
                            x.get(0),
                            postulant.getChallenge().getRegistrationDate().toString(),
                            postulant.getChallenge().getInitialDate().toString(),
                            postulant.getChallenge().getFinalDate().toString(),
                            postulant.getChallenge().getLanguage());
                    postulant.setChallenge(newChallenge);
                    return postulant;
                }).flatMap(postulant -> postulantRepository.update(idPostulant, postulant));
    }
}
