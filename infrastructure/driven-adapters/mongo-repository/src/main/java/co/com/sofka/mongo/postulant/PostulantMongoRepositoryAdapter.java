package co.com.sofka.mongo.postulant;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.logging.Logger;


@Repository
public class PostulantMongoRepositoryAdapter extends AdapterOperations<Postulant, PostulantDocument, String, PostulantMongoDBRepository>
implements PostulantRepository {
        final Logger LOG = Logger.getLogger("Logger");
        public PostulantMongoRepositoryAdapter(PostulantMongoDBRepository repository, ObjectMapper mapper) {
                super(repository, mapper, d -> mapper.map(d, Postulant.class));
        }

        @Override
        public Mono<Postulant> update(String id, Postulant postulant) {
                return repository.save(new PostulantDocument(
                                id,
                                postulant.getFullName(),
                                postulant.getDocumentUser(),
                                postulant.getDateOfBirth(),
                                postulant.getNationality(),
                                postulant.getUrlPhoto(),
                                postulant.getPhone(),
                                postulant.getEmail(),
                                postulant.getCompanyName(),
                                postulant.getWorkExperience(),
                                postulant.getCurrentOccupation(),
                                postulant.getEducationalLevel(),
                                postulant.getCountry(),
                                postulant.getDepartment(),
                                postulant.getMunicipality(),
                                postulant.getAddress(),
                                postulant.getEnglishLevel(),
                                postulant.getIsStudying(),
                                postulant.getAboutYou(),
                                postulant.getUrlCV(),
                                postulant.getLinkedin(),
                                postulant.getSessionOn(),
                                postulant.getChallenge(),
                                postulant.getIdTraining())).flatMap(postulantDocument -> Mono.just(postulant));
        }

        @Override
        public Flux<String> findWhoStart(String date) {
                var searchedDate = LocalDate.parse(date);
                return repository.findAll()
                        .filter(postulantDocument -> postulantDocument.getChallenge().getInitialDate().equals(searchedDate))
                        .onErrorContinue((throwable, o) -> LOG.info( throwable.getMessage()))
                        .map(PostulantDocument::getEmail);

                /*postulantDocument.getChallenge().getInitialDate().getYear() == searchedDate.getYear() &&
                postulantDocument.getChallenge().getInitialDate().getMonth().equals(searchedDate.getMonth()) &&
                postulantDocument.getChallenge().getInitialDate().getDayOfMonth() == searchedDate.getDayOfMonth()*/
        }
}
