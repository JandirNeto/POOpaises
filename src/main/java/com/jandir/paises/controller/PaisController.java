package com.jandir.paises.controller;

import com.jandir.paises.model.Pais;
import com.jandir.paises.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList; // Importe ArrayList
import java.util.List;
import java.util.Optional; // Importe Optional se ainda não estiver

@Controller
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/")
    public String listaPaises(@RequestParam(required = false) List<String> continente, Model model) {
        // Garante que 'continente' nunca seja null ao passar para o serviço e para o modelo
        List<String> filtrosParaServico = Optional.ofNullable(continente).orElseGet(ArrayList::new);

        List<Pais> paises = paisService.filtrarPorContinentes(filtrosParaServico);
        model.addAttribute("paises", paises);
        model.addAttribute("filtrosSelecionados", filtrosParaServico); // Agora sempre será uma lista (pode ser vazia)
        return "lista";
    }

    @GetMapping("/novo")
    public String novoPaisForm(Model model) {
        model.addAttribute("pais", new Pais("", "", "", ""));
        return "form";
    }

    @GetMapping("/editar/{nome}")
    public String editarPaisForm(@PathVariable String nome, Model model) {
        Pais pais = paisService.buscarPorNome(nome).orElseThrow(() -> new IllegalArgumentException("País não encontrado: " + nome));
        model.addAttribute("pais", pais);
        return "form";
    }

    @PostMapping("/salvar")
    public String salvarPais(@ModelAttribute Pais pais) {
        paisService.salvar(pais);
        return "redirect:/pais/";
    }

    @GetMapping("/deletar/{nome}")
    public String deletarPais(@PathVariable String nome) {
        paisService.deletarPorNome(nome);
        return "redirect:/pais/";
    }

    // Endpoint para autocomplete (via AJAX, por exemplo)
    @GetMapping("/autocomplete")
    @ResponseBody
    public Pais autocomplete(@RequestParam String nome) {
        return paisService.autocomplete(nome).orElse(null);
    }
}