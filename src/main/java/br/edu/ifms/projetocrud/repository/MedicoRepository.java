package br.edu.ifms.projetocrud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projetocrud.model.Medico;

@Repository

public interface MedicoRepository extends JpaRepository <Medico, UUID> {
    
}
