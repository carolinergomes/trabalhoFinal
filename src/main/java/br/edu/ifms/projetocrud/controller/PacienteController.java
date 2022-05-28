package br.edu.ifms.projetocrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.projetocrud.model.Paciente;
import br.edu.ifms.projetocrud.services.MedicoService;
import br.edu.ifms.projetocrud.services.PacienteService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/paciente")
@Slf4j

public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @Autowired
    MedicoService medicoService;

    @GetMapping("/")
    public String listPacientes(Model model){
        
        List<Paciente> pacientes = new ArrayList<Paciente>();
        pacientes = pacienteService.listPacientes();
        
        model.addAttribute("pacientes", pacientes);

        return "listPacientes";
    }

    @PostMapping("/savePaciente")
    public String novoPaciente(@ModelAttribute Paciente paciente){
       pacienteService.salvar(paciente);
        return "redirect:/paciente/";
    }

    @GetMapping("/cadastrar")
    public String newPaciente(Model model){
        model.addAttribute("paciente", new Paciente());
        return "cadastroPaciente.html";
    }

    @GetMapping("/edit/{id}")
    public Paciente editPaciente(@PathVariable("id") UUID id, Model model){
        Paciente paciente = pacienteService.findById(id);
        return paciente;
    }

    @GetMapping("/deletePaciente/{id}")
    public String removePaciente(@PathVariable("id") UUID id){
        log.info("id =" + id);
        pacienteService.delete(id);
        return "redirect:/paciente/";
    }

    @PostMapping("/updatePaciente/{id}")
    public String updatePaciente(@PathVariable("id") UUID id, @ModelAttribute Paciente paciente, Model model){
        pacienteService.updatePaciente(paciente);
        return "redirect:/paciente/";
    }
}
