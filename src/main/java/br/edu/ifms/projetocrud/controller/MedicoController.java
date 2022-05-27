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

import br.edu.ifms.projetocrud.model.Medico;
import br.edu.ifms.projetocrud.services.MedicoService;
import br.edu.ifms.projetocrud.services.PacienteService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/medico")
@Slf4j

public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/")
    public String listMedicos(Model model){
        
        List<Medico> medicos = new ArrayList<Medico>();
        medicos = medicoService.listMedicos();
        
        model.addAttribute("medicos", medicos);

        return "list-medicos";

    }

    // @GetMapping("/novo")
    // public String novoMedico(Model model) {
    //     model.addAttribute("medico", new Medico());
    //     List<paciente> pacientes = new ArrayList<Paciente>();
    //     pacientes = pacienteService.getPacientes();
    //     model.addAttribute("pacientes", pacientes);
    //     return "cadastrar-medico";
    // }

    @PostMapping("/salvar")
    public String novoMedico(@ModelAttribute Medico medico){
       medicoService.salvar(medico);
        return "redirect:/medico/";
    }

    @GetMapping("/cadastrar")
    public String newMedico(Model model){
        model.addAttribute("medico", new Medico());
        return "";
    }

    @GetMapping("/remover/{id}")
    public String removeMedico(@PathVariable("id") UUID id){
        log.info("id =" + id);
        medicoService.delete(id);
        return "redirect:/medico/";
    }

    @GetMapping("/editar/{id}")
    public Medico editMedicos(@PathVariable("id") UUID id, Model model, Object log){
        Medico medico = medicoService.findById(id);
        log.info("medico pwd = " + medico.getPassword());
        return medico;
    }

    @PostMapping("/update/{id}")
    public String updateMedico(@PathVariable("id") UUID id, @ModelAttribute Medico medico, Model model){
        medicoService.updateMedico(medico);
        return "redirect:/medico/";
    }
}
