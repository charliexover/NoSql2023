package tecno.nosql2023.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tecno.nosql2023.model.Persona;
import tecno.nosql2023.repository.PersonaRepository;
import tecno.nosql2023.model.excepcionHandler.ExcepcionCustom;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Flux<Persona> getAllPersonas(){
        return this.personaRepository.findAll();
    }

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
    public Mono<Persona> addPersona(Persona persona) {
        return this.personaRepository.findById(persona.getCi())
                .flatMap(existingUser -> Mono.error(new ExcepcionCustom("Ya existe una persona con esa cedula ", HttpStatus.UNAUTHORIZED)))
                .then(this.personaRepository.save(persona));
    }

}
