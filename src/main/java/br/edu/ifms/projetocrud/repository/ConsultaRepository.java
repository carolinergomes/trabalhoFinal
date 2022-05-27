package br.edu.ifms.projetocrud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.projetocrud.model.Consulta;

public interface ConsultaRepository extends JpaRepository <Consulta, UUID> {
    
}
