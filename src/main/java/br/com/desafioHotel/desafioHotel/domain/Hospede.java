package br.com.desafioHotel.desafioHotel.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Hospede  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_hospede")
    @NotNull
    private Integer idHospede;

    @Column(name = "nome_hospede")
    @NotNull
    private String nomeHospede;

    @Column(name = "documento_hospede")
    @NotNull
    private String documentoHospede;

    @Column(name = "telefone_hospede")
    @NotNull
    private String telefoneHospede;

    @Column(name="hospedado")
    @NotNull
    private String hospedado;
}
