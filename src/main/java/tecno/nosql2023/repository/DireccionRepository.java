package tecno.nosql2023.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import tecno.nosql2023.model.Direccion;

@Repository
public interface DireccionRepository extends ReactiveMongoRepository<Direccion, Integer> {
    Mono<Direccion> findById(int id_Dir);
}
