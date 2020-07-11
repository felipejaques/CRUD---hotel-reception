package br.com.desafioHotel.desafioHotel.repositories;

import br.com.desafioHotel.desafioHotel.domain.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospedeRepositories extends JpaRepository<Hospede, Integer> {

     public Optional <List<Hospede>> findByNomeHospedeOrDocumentoHospedeOrTelefoneHospede(
             String nomeHospede,
             String documentoHospede,
             String telefoneHospede);

     public Optional <List<Hospede>> findByHospedado(String s);
}
