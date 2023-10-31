package tecno.nosql2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tecno.nosql2023.model.Direccion;
import tecno.nosql2023.repository.DireccionRepository;
import tecno.nosql2023.model.excepcionHandler.ExcepcionCustom;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public Flux<Direccion> getAllDirecciones(){
        return this.direccionRepository.findAll();
    }

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }
    public Mono<Direccion> addDireccion(Direccion direccion) {
        return this.direccionRepository.findById(direccion.getId_Dir())
                .flatMap(existingUser -> Mono.error(new ExcepcionCustom("Ya existe una direccion con ese id ", HttpStatus.UNAUTHORIZED)))
                .then(this.direccionRepository.save(direccion));

    }
}
