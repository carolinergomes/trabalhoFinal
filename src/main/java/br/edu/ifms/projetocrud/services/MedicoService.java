package br.edu.ifms.projetocrud.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projetocrud.model.Medico;
import br.edu.ifms.projetocrud.repository.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository medicoRepository;

    public void salvar(Medico medico){
        medicoRepository.save(medico);
    }

    public List<Medico> listMedicos(){
        return medicoRepository.findAll();
    }

    public void delete(UUID id){
        medicoRepository.deleteById(id);
    }

    public Medico findById(UUID id) {
        return medicoRepository.findById(id).get();
    }
    
    public void updateMedico(Medico medico){
        medicoRepository.save(medico);
    }
}
