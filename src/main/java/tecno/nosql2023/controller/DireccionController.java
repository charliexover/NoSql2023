package tecno.nosql2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tecno.nosql2023.service.DireccionService;
import tecno.nosql2023.model.Direccion;

@RestController
@RequestMapping("/api")
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @GetMapping("/getAllDirecciones")
    public ResponseEntity<Flux<Direccion>> getAllDirecciones(){
        Flux<Direccion> direccionesAll=this.direccionService.getAllDirecciones();
        return new ResponseEntity<>(direccionesAll, HttpStatus.OK);
    }
    @PostMapping("/addDireccion")
    public ResponseEntity<Mono<Direccion>> addDireccion(@RequestBody Direccion direccion) throws Exception {
        Mono<Direccion> direccionAdd=this.direccionService.addDireccion(direccion);
        return new ResponseEntity<>(direccionAdd, HttpStatus.CREATED);
    }
}

