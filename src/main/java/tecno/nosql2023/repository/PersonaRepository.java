package tecno.nosql2023.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import tecno.nosql2023.model.Persona;


@Repository
public interface PersonaRepository extends ReactiveMongoRepository<Persona,String> {
    Mono<Persona> findById(String id);
}
