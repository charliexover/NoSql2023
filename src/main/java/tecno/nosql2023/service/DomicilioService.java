package tecno.nosql2023.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tecno.nosql2023.model.Domicilio;
import tecno.nosql2023.model.excepcionHandler.ExcepcionCustom;
import tecno.nosql2023.repository.DomicilioRepository;
import tecno.nosql2023.repository.PersonaRepository;

@Service
public class DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;
    @Autowired
    private PersonaRepository personaRepository;

    public DomicilioService(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }
    public Flux<Domicilio> getAllDomicilios(){
        return this.domicilioRepository.findAll();
    }

    public Flux<Domicilio> getAllDomiciliosPersona(String ciPersona){
        return this.domicilioRepository.findByCiPerOrderByIdDomDesc(ciPersona)
                .switchIfEmpty(Mono.error(new ExcepcionCustom("No existe una persona con la cedula ingresada ", HttpStatus.UNAUTHORIZED)));
    }

    public Flux<Domicilio> getAllDomCrit(String barrio, String localidad, String depto){
        return this.domicilioRepository.findByBarrioOrDepartamentoOrLocalidad(barrio, localidad, depto);
    }
    public Mono<Domicilio> addDomicilio(String ciPersona, Domicilio domicilio) {
        ObjectId obj = new ObjectId();
        int objString = obj.getTimestamp();
        domicilio.setIdDom(objString);
        domicilio.setCiPer(ciPersona);
        return this.personaRepository.findById(ciPersona)
                .switchIfEmpty(Mono.error(new ExcepcionCustom("No existe una persona con la cedula ingresada ", HttpStatus.UNAUTHORIZED)))
                .then(this.domicilioRepository.save(domicilio));
    }
}
