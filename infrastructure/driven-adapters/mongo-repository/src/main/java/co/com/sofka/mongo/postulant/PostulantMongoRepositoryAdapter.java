package co.com.sofka.mongo.postulant;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class PostulantMongoRepositoryAdapter extends AdapterOperations<Postulant, PostulantDocument, String, PostulantMongoDBRepository>
implements PostulantRepository {

        public PostulantMongoRepositoryAdapter(PostulantMongoDBRepository repository, ObjectMapper mapper) {
                super(repository, mapper, d -> mapper.map(d, Postulant.class));
        }

        @Override
        public Mono<Postulant> update(String id, Postulant postulant) {
                return repository.save(new PostulantDocument(
                        id,
                        postulant.getDocumentUser(),
                        postulant.getDateOfBirth(),
                        postulant.getNationality(),
                        postulant.getUrlPhoto(),
                        postulant.getPhone(),
                        postulant.getWorkExperience(),
                        postulant.getCurrentOccupation(),
                        postulant.getEducationalLevel(),
                        postulant.getCountry(),
                        postulant.getDepartament(),
                        postulant.getMunicipality(),
                        postulant.getAddress(),
                        postulant.getEnglishLevel(),
                        postulant.getIsStudying(),
                        postulant.getAboutYou(),
                        postulant.getUrlCV(),
                        postulant.getLinkedin(),
                        postulant.getSessionOn(),
                        postulant.getChallenge()
                )).flatMap(postulantDocument -> Mono.just(postulant));
        }
}
