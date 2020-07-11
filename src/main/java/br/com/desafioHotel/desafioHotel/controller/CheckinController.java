package br.com.desafioHotel.desafioHotel.controller;

import br.com.desafioHotel.desafioHotel.domain.Checkin;
import br.com.desafioHotel.desafioHotel.services.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/checkin", produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckinController {

    @Autowired
    private CheckinService cService;

    @GetMapping()
    public ResponseEntity<?> findAll(){

        List<Checkin> conteudo = cService.findAll();
        return ResponseEntity.ok().body(conteudo);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> findOneById(@PathVariable Integer id){
        Optional<Checkin> t = cService.findById(id);
        return ResponseEntity.ok().body(t);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Checkin checkin){
        cService.save(checkin);
        return ResponseEntity.ok().body("Hóspede salvo");
    }

    @PutMapping()
    public ResponseEntity<?> alter( @RequestBody Checkin checkin){
        cService.save(checkin);
        return ResponseEntity.ok().body("Hóspede alterado");
    }

    @GetMapping(value="/hospedes-checkin")
    public ResponseEntity<?> findByFinish(){
        Optional <List<Checkin>> t = cService.findByFinish();
        return ResponseEntity.ok().body(t);
    }
}
