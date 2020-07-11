package br.com.desafioHotel.desafioHotel.services;

import br.com.desafioHotel.desafioHotel.domain.Hospede;
import br.com.desafioHotel.desafioHotel.exception.ObjectNotFoundException;
import br.com.desafioHotel.desafioHotel.repositories.HospedeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepositories repository;

    public List<Hospede> findAll(){

        return repository.findAll();
    }

    public void save(Hospede hospede) {

        repository.save(hospede);
    }

    public Optional<Hospede> findById(Integer idHospede) {
        Optional<Hospede> obj = repository.findById(idHospede);

        if(!obj.isPresent()) {
            throw new ObjectNotFoundException("Objeto id: " + idHospede + " não foi encontrado!");
        }

        return obj;
    }

    public Optional <List<Hospede>> findByName(Hospede hospede) {
        Optional <List<Hospede>> obj =
                repository.findByNomeHospedeOrDocumentoHospedeOrTelefoneHospede(
                        hospede.getNomeHospede(),
                        hospede.getDocumentoHospede(),
                        hospede.getTelefoneHospede());

        if(!obj.isPresent()) {
            throw new ObjectNotFoundException("Objeto não foi encontrado!");
        }
        return obj;
    }

    public Optional<List<Hospede>> findByHosted() {
        Optional <List<Hospede>> obj = repository.findByHospedado("S");
        return obj;
    }
}
