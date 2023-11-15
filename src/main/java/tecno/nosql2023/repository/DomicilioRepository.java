package tecno.nosql2023.repository;

import com.mongodb.DBRef;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import tecno.nosql2023.model.Domicilio;

@Repository
public interface DomicilioRepository extends ReactiveMongoRepository<Domicilio, Integer> {
    Flux<Domicilio> findByCiPerOrderByIdDomDesc(String ciPer, Pageable pageable);
    Flux<Domicilio> findByBarrioLike(String barrio);
    Flux<Domicilio> findByLocalidadLike(String localidad);
    Flux<Domicilio> findByDepartamentoLike(String depto);
    Flux<Domicilio> findByBarrioLikeAndLocalidadLike(String barrio,String localidad);
    Flux<Domicilio> findByBarrioLikeAndDepartamentoLike(String barrio,String depto);
    Flux<Domicilio> findByLocalidadLikeAndDepartamentoLike(String localidad,String depto);
    Flux<Domicilio> findByBarrioLikeAndLocalidadLikeAndDepartamentoLike(String barrio,String localidad, String depto);
    default Flux<Domicilio> buscarDom(String barrio, String localidad, String depto){
        if(barrio != null && localidad != null && depto != null) {
            return findByBarrioLikeAndLocalidadLikeAndDepartamentoLike(barrio, localidad, depto);
        } else if (barrio != null && localidad != null) {
            return findByBarrioLikeAndLocalidadLike(barrio, localidad);
        } else if (barrio != null && depto != null) {
            return findByBarrioLikeAndDepartamentoLike(barrio, depto);
        } else if (localidad != null && depto != null) {
            return findByLocalidadLikeAndDepartamentoLike(localidad, depto);
        } else if (barrio != null) {
            return findByBarrioLike(barrio);
        } else if (localidad != null) {
            return findByLocalidadLike(localidad);
        } else if (depto != null) {
            return findByDepartamentoLike(depto);
        }
        return null;
    };
}
