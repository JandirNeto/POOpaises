package com.jandir.paises.controller;

import com.jandir.paises.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/")
    public String listaPaises(@RequestParam(required = false) String continente, Model model) {
        model.addAttribute("paises", paisService.filtrarPorContinente(continente));
        return "lista";
    }
}
