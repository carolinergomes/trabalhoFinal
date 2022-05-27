package br.edu.ifms.projetocrud.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.projetocrud.model.Consulta;
import br.edu.ifms.projetocrud.repository.ConsultaRepository;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository;

    public void salvar(Consulta consulta){
        consultaRepository.save(consulta);
    }

    public void delete(UUID id){
        consultaRepository.deleteById(id);
    }

    public Consulta findById(UUID id) {
        return consultaRepository.findById(id).get();
    }
    
    public void updateConsulta(Consulta consulta){
        consultaRepository.save(consulta);
    }
}
