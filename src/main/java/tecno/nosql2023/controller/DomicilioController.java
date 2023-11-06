package tecno.nosql2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tecno.nosql2023.model.Domicilio;
import tecno.nosql2023.service.DomicilioService;
import tecno.nosql2023.service.PersonaService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DomicilioController {
    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/getAllDomicilios")
    public ResponseEntity<Flux<Domicilio>> getAllDomicilios(){
        Flux<Domicilio> domiciliosAll=this.domicilioService.getAllDomicilios();
        return new ResponseEntity<>(domiciliosAll, HttpStatus.OK);
    }

    @GetMapping("/getAllDomicilios/{ciPersona}")
    public ResponseEntity<Flux<Domicilio>> getAllDomiciliosPersona(@PathVariable("ciPersona") String ciPersona){
        Flux<Domicilio> domiciliosAllPersona=this.domicilioService.getAllDomiciliosPersona(ciPersona);
        return new ResponseEntity<>(domiciliosAllPersona, HttpStatus.OK);
    }

    @GetMapping("/getAllDomCriterio/?barrio={barrio}&localidad={localidad}&depto={depto}")
    public ResponseEntity<Flux<Domicilio>> getAllDomCriterio(@PathVariable("barrio") String barrio, @PathVariable("localidad") String localidad, @PathVariable("depto") String depto){
        Flux<Domicilio> domiciliosCrit=this.domicilioService.getAllDomCrit(barrio, localidad, depto);
        return new ResponseEntity<>(domiciliosCrit, HttpStatus.OK);
    }
    @PostMapping("/addDomicilio/{ciPersona}")
    public ResponseEntity<Mono<Domicilio>> addDomicilio( @PathVariable("ciPersona") String ciPersona, @RequestBody Domicilio domicilio) throws Exception{
        Mono<Domicilio> domicilioAdd=this.domicilioService.addDomicilio(ciPersona, domicilio);
        return new ResponseEntity<>(domicilioAdd, HttpStatus.CREATED);
    }

}
