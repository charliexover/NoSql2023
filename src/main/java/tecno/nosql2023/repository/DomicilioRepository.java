package tecno.nosql2023.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import tecno.nosql2023.model.Domicilio;

@Repository
public interface DomicilioRepository extends ReactiveMongoRepository<Domicilio, Integer> {
    Flux<Domicilio> findByCiPerOrderByIdDomDesc(String ciPer);

    Flux<Domicilio> findByBarrioOrDepartamentoOrLocalidad(String barrio, String localidad, String depto);
}
