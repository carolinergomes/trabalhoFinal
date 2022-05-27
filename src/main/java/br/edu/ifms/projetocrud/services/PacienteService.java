package br.edu.ifms.projetocrud.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projetocrud.model.Paciente;
import br.edu.ifms.projetocrud.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public void salvar(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public List<Paciente> listPacientes(){
        return pacienteRepository.findAll();
    }

    public void delete(UUID id){
        pacienteRepository.deleteById(id);
    }

    public Paciente findById(UUID id) {
        return pacienteRepository.findById(id).get();
    }
    
    public void updatePaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }
}
