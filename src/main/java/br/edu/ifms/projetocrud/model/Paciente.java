package br.edu.ifms.projetocrud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Paciente {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    
    private int id;

    private String nome;
    private int telefone;
    private String endereco;

    @ManyToMany(mappedBy = "pacientes")
    private List<Medico> medicos;  

    @OneToOne(cascade = { CascadeType.DETACH})
    @JoinColumn( name = "consulta_id")
    private Consulta consulta;

    @OneToOne(cascade = { CascadeType.DETACH})
    @JoinColumn( name = "exame_id")
    private Exame exame;
}