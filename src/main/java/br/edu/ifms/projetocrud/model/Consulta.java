package br.edu.ifms.projetocrud.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Consulta {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    private int id;

    private String consultorio;
    private Date data;
    private int hora;

    @OneToOne(cascade = { CascadeType.DETACH})
    @JoinColumn( name = "paciente_id")
    private Paciente paciente;

    @OneToOne(cascade = { CascadeType.DETACH})
    @JoinColumn( name = "medico_id")
    private Medico medico;
}
