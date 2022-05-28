package br.edu.ifms.projetocrud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.projetocrud.model.Consulta;
import br.edu.ifms.projetocrud.services.ConsultaService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/consulta")
@Slf4j

public class ConsultaController {
    @Autowired
    ConsultaService consultaService;
    
    @PostMapping("/saveConsulta")
    public String novaConsulta(@ModelAttribute Consulta consulta){
       consultaService.salvar(consulta);
        return "redirect:/consulta/";
    }

    @GetMapping("/cadastrar")
    public String newConsulta(Model model){
        model.addAttribute("consulta", new Consulta());
        return "cadastroConsulta.html";
    }

    @GetMapping("/edit/{id}")
    public Consulta editConsulta(@PathVariable("id") UUID id, Model model){
        Consulta consulta = consultaService.findById(id);
        return consulta;
    }

    @GetMapping("/deleteConsulta/{id}")
    public String removeConsulta(@PathVariable("id") UUID id){
        log.info("id =" + id);
        consultaService.delete(id);
        return "redirect:/consulta/";
    }

    @PostMapping("/updateConsulta/{id}")
    public String updateConsulta(@PathVariable("id") UUID id, @ModelAttribute Consulta consulta, Model model){
        consultaService.updateConsulta(consulta);
        return "redirect:/consulta/";
    }
}
