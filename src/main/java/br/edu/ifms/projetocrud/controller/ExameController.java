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

import br.edu.ifms.projetocrud.model.Exame;
import br.edu.ifms.projetocrud.services.ExameService;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/exame")
@Slf4j

public class ExameController {
    @Autowired
    ExameService exameService;

    @PostMapping("/saveExame")
    public String novoExame(@ModelAttribute Exame exame){
       exameService.salvar(exame);
        return "redirect:/exame";
    }

    @GetMapping("/deleteExame/{id}")
    public String removeExame(@PathVariable("id") UUID id){
        log.info("id =" + id);
        exameService.delete(id);
        return "redirect:/exame/";
    }

    @PostMapping("/updateExame/{id}")
    public String updatePaciente(@PathVariable("id") UUID id, @ModelAttribute Exame exame, Model model){
        exameService.updateExame(exame);
        return "redirect:/exame/";
    }
}

