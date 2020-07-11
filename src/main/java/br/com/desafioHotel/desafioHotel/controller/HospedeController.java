package br.com.desafioHotel.desafioHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import br.com.desafioHotel.desafioHotel.domain.Hospede;
import br.com.desafioHotel.desafioHotel.services.HospedeService;

@RestController
@RequestMapping(value="/hospedes", produces = MediaType.APPLICATION_JSON_VALUE)
public class HospedeController {

    @Autowired
    private HospedeService service;

    @GetMapping()
    public ResponseEntity<?> findAll(){
        List<Hospede> hospede = service.findAll();
        return ResponseEntity.ok().body(hospede);
    }

    @GetMapping(value="/{idHospede}")
    public ResponseEntity<?> findOneById(@PathVariable Integer idHospede){
        Optional<Hospede> t = service.findById(idHospede);
        return ResponseEntity.ok().body(t);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Hospede hospede){
        service.save(hospede);
        return ResponseEntity.ok().body("Hóspede salvo");
    }

    @PutMapping()
    public ResponseEntity<?> alter(@RequestBody Hospede hospede){
        service.save(hospede);
        return ResponseEntity.ok().body("Hóspede alterado");
    }

    @GetMapping(value="/name-doc-phone")
    public ResponseEntity<?> findOneByName(@RequestBody Hospede hospede){
        Optional <List<Hospede>> t = service.findByName(hospede);
        return ResponseEntity.ok().body(t);
    }

    @GetMapping(value="/hospedados")
    public ResponseEntity<?> findByHosted(){
        Optional  <List<Hospede>> t = service.findByHosted();
        return ResponseEntity.ok().body(t);
    }
}
