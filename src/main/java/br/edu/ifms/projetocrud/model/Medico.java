package br.edu.ifms.projetocrud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medico {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    private int id;
    private String nome;
    private String especializacao;
    private int crm;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "PACIENTE_MEDICO",
        joinColumns = { 
            @JoinColumn(name = "MEDICO_ID")},
            inverseJoinColumns = { @JoinColumn(name = "PACIENTE_ID")
    }
        )
    private List<Paciente> pacientes;

    @OneToOne(cascade = { CascadeType.DETACH})
    @JoinColumn( name = "consulta_id")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn( name =  "exame_id", nullable = false)
    private Exame exame;
}
