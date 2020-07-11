package br.com.desafioHotel.desafioHotel.services;

import br.com.desafioHotel.desafioHotel.repositories.CheckinRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.desafioHotel.desafioHotel.domain.Checkin;
import br.com.desafioHotel.desafioHotel.exception.ObjectNotFoundException;


@Service
public class CheckinService {
    @Autowired
    private CheckinRepositories cRepository;

    public List<Checkin> findAll(){
        return cRepository.findAll();
    }

    public void save(Checkin checkin) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date dataEntrada = format.parse(checkin.getDataEntrada());
            Date dataSaida = format.parse(checkin.getDataSaida());
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataEntrada);
            int diaSemanaEntrada = cal.get(Calendar.DAY_OF_WEEK);
            cal.setTime(dataSaida);
            int diaSemanaSaida = cal.get(Calendar.DAY_OF_WEEK);
            if(diaSemanaEntrada == 1 || diaSemanaEntrada == 7 || diaSemanaSaida == 1 || diaSemanaSaida == 7){ //final de semana
                if(checkin.getGastosHospede() != 150.00){
                    checkin.setGastosHospede(150.00);
                }
                if(checkin.isVeiculo()){
                    checkin.setGastosHospede(checkin.getGastosHospede() + 20);
                }
            } else { // semana
                checkin.setGastosHospede(120.00);
                if(checkin.isVeiculo()){
                    checkin.setGastosHospede(checkin.getGastosHospede() + 15);
                }
            }
            int horaSaida = cal.get(Calendar.HOUR);
            if(horaSaida >= 4){ // taxa extra
                checkin.setGastosHospede(checkin.getGastosHospede() + 20);
            }
        } catch (ParseException e){
            e.printStackTrace();
        }
        cRepository.save(checkin);
    }

    public Optional<Checkin> findById(Integer id) {
        Optional<Checkin> obj = cRepository.findById(id);
        if(!obj.isPresent()) {
            throw new ObjectNotFoundException("Objeto id: " + id + " não foi encontrado!");
        }
        return obj;
    }

    public Optional<List<Checkin>> findByFinish() {
        Optional<List<Checkin>> obj = cRepository.findByFinalizado("S");
        return obj;
    }
}
