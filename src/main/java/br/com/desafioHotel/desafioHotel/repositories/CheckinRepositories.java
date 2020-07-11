package br.com.desafioHotel.desafioHotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import br.com.desafioHotel.desafioHotel.domain.Checkin;

@Repository
public interface CheckinRepositories extends JpaRepository<Checkin, Integer> {

    public Optional <List<Checkin>> findByFinalizado( String s);

}
