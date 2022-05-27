package br.edu.ifms.projetocrud.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projetocrud.model.Exame;
import br.edu.ifms.projetocrud.repository.ExameRepository;

@Service
public class ExameService {
    @Autowired
    ExameRepository exameRepository;

    public void salvar(Exame exame){
        exameRepository.save(exame);
    }

    public void delete(UUID id){
        exameRepository.deleteById(id);
    }

    public Exame findById(UUID id) {
        return exameRepository.findById(id).get();
    }
    
    public void updateExame(Exame exame){
        exameRepository.save(exame);
    }
}
