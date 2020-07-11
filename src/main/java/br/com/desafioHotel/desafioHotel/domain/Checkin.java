package br.com.desafioHotel.desafioHotel.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Checkin {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_checkin")
    private Integer idCheckin;

    @Column(name="id_hospede")
    @NotNull
    private Integer idHospede;

    @Column(name="data_entrada")
    @NotNull
    private String dataEntrada;

    @Column(name="data_Saida")
    private String dataSaida;

    @Column(name="veiculo")
    private boolean veiculo;

    @Column(name="finalizado")
    private String finalizado;

    @Column(name="gastos_hospede")
    @NotNull
    private double gastosHospede;
}
