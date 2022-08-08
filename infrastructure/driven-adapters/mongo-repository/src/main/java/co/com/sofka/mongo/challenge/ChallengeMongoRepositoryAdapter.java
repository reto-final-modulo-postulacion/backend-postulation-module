package co.com.sofka.mongo.challenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Repository
public class ChallengeMongoRepositoryAdapter extends AdapterOperations<Challenge, ChallengeDocument, String, ChallengeMongoDBRepository>
implements ChallengeRepository {
    public ChallengeMongoRepositoryAdapter(ChallengeMongoDBRepository repository, ObjectMapper mapper, Function<ChallengeDocument, Challenge> toEntityFn) {
        super(repository, mapper, d -> mapper.map(d, Challenge.class));
    }

    @Override
    public Mono<Challenge> update(String id, Challenge challenge) {
        return repository.save(new ChallengeDocument(
                id,
                challenge.getName(),
                challenge.getDescription(),
                challenge.getUrlDocument()
        )).flatMap(challengeDocument -> Mono.just(challenge));
    }
}
