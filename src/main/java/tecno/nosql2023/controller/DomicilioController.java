package tecno.nosql2023.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @RequestMapping("/getDomiciliosPersona")
    public ResponseEntity<Flux<Domicilio>> getDomiciliosPersona(@RequestParam(value = "ci") String ciPersona, @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                                   @RequestParam(value = "size", defaultValue = "5", required = false) int size){
        Pageable paging = PageRequest.of(page, size);
        Flux<Domicilio> domiciliosAllPersona=this.domicilioService.getAllDomiciliosPersona(ciPersona, paging);
        return new ResponseEntity<>(domiciliosAllPersona, HttpStatus.OK);
    }

    @RequestMapping("/getAllDomCriterio")
    public ResponseEntity<Flux<Domicilio>> getAllDomCriterio(@Nullable @RequestParam(value = "barrio", required = false) String barrio, @Nullable @RequestParam(value = "localidad", required = false) String localidad, @Nullable @RequestParam(value = "depto", required = false) String depto){
        Flux<Domicilio> domiciliosCrit=this.domicilioService.getAllDomCrit(barrio, localidad, depto);
        return new ResponseEntity<>(domiciliosCrit, HttpStatus.OK);
    }
    @PostMapping("/addDomicilio/{ciPersona}")
    public ResponseEntity<Mono<Domicilio>> addDomicilio( @PathVariable("ciPersona") String ciPersona, @RequestBody Domicilio domicilio) throws Exception{
        Mono<Domicilio> domicilioAdd=this.domicilioService.addDomicilio(ciPersona, domicilio);
        return new ResponseEntity<>(domicilioAdd, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDomicilios")
    public ResponseEntity<Mono<Void>> deleteDomicilios(){
        Mono<Void> domicilioDelete=this.domicilioService.deleteAllDom();
        return new ResponseEntity<>(domicilioDelete, HttpStatus.CREATED);
    }
}
