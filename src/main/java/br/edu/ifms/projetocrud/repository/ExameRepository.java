package br.edu.ifms.projetocrud.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.projetocrud.model.Exame;

@Repository
public interface ExameRepository extends JpaRepository <Exame, UUID> {
    
}
