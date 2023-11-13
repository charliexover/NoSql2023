package tecno.nosql2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tecno.nosql2023.service.PersonaService;
import tecno.nosql2023.model.Persona;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

@GetMapping("/getAllPersonas")
    public ResponseEntity<Flux<Persona>> getAllPersonas(){
        Flux<Persona> personasAll=this.personaService.getAllPersonas();
        return new ResponseEntity<>(personasAll, HttpStatus.OK);
    }

@PostMapping("/addPersona")
    public ResponseEntity<Mono<Persona>> addPersona(@RequestBody Persona persona) throws Exception {
        Mono<Persona> personaAdd=this.personaService.addPersona(persona);
        return new ResponseEntity<>(personaAdd, HttpStatus.CREATED);
    }
@DeleteMapping("/deletePersonas")
    public ResponseEntity<Mono<Void>> deletePersonas() {
        Mono<Void> personaDelete=this.personaService.deleteAllPersonas();
        return new ResponseEntity<>(personaDelete, HttpStatus.CREATED);
    }
}
