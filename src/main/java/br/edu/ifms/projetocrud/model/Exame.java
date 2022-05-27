package br.edu.ifms.projetocrud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Exame {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    private int id;

    private String nome;

@OneToMany
@JoinColumn( name = "exame_id")

private List<Medico> medicos;  

@OneToOne(cascade = { CascadeType.DETACH})
    @JoinColumn( name = "paciente_id")
    private Paciente paciente;
}
