package com.jandir.paises.service;

import com.jandir.paises.model.Pais;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisService {

    private List<Pais> paises = List.of(
            // América do Sul
            new Pais("Brasil", "Brasília", "América do Sul", "https://flagcdn.com/br.svg"),
            new Pais("Argentina", "Buenos Aires", "América do Sul", "https://flagcdn.com/ar.svg"),
            new Pais("Colômbia", "Bogotá", "América do Sul", "https://flagcdn.com/co.svg"),
            new Pais("Peru", "Lima", "América do Sul", "https://flagcdn.com/pe.svg"),
            new Pais("Chile", "Santiago", "América do Sul", "https://flagcdn.com/cl.svg"),

            // América do Norte
            new Pais("Estados Unidos", "Washington, D.C.", "América do Norte", "https://flagcdn.com/us.svg"),
            new Pais("Canadá", "Ottawa", "América do Norte", "https://flagcdn.com/ca.svg"),
            new Pais("México", "Cidade do México", "América do Norte", "https://flagcdn.com/mx.svg"),
            new Pais("Cuba", "Havana", "América do Norte", "https://flagcdn.com/cu.svg"),
            new Pais("Honduras", "Tegucigalpa", "América do Norte", "https://flagcdn.com/hn.svg"),

            // Europa
            new Pais("França", "Paris", "Europa", "https://flagcdn.com/fr.svg"),
            new Pais("Alemanha", "Berlim", "Europa", "https://flagcdn.com/de.svg"),
            new Pais("Itália", "Roma", "Europa", "https://flagcdn.com/it.svg"),
            new Pais("Espanha", "Madri", "Europa", "https://flagcdn.com/es.svg"),
            new Pais("Portugal", "Lisboa", "Europa", "https://flagcdn.com/pt.svg"),

            // Ásia
            new Pais("Japão", "Tóquio", "Ásia", "https://flagcdn.com/jp.svg"),
            new Pais("China", "Pequim", "Ásia", "https://flagcdn.com/cn.svg"),
            new Pais("Índia", "Nova Deli", "Ásia", "https://flagcdn.com/in.svg"),
            new Pais("Coreia do Sul", "Seul", "Ásia", "https://flagcdn.com/kr.svg"),
            new Pais("Indonésia", "Jacarta", "Ásia", "https://flagcdn.com/id.svg"),

            // África
            new Pais("Egito", "Cairo", "África", "https://flagcdn.com/eg.svg"),
            new Pais("Nigéria", "Abuja", "África", "https://flagcdn.com/ng.svg"),
            new Pais("África do Sul", "Pretória", "África", "https://flagcdn.com/za.svg"),
            new Pais("Quênia", "Nairóbi", "África", "https://flagcdn.com/ke.svg"),
            new Pais("Marrocos", "Rabat", "África", "https://flagcdn.com/ma.svg"),

            // Oceania
            new Pais("Austrália", "Camberra", "Oceania", "https://flagcdn.com/au.svg"),
            new Pais("Nova Zelândia", "Wellington", "Oceania", "https://flagcdn.com/nz.svg"),
            new Pais("Fiji", "Suva", "Oceania", "https://flagcdn.com/fj.svg"),
            new Pais("Samoa", "Apia", "Oceania", "https://flagcdn.com/ws.svg"),
            new Pais("Papua Nova Guiné", "Port Moresby", "Oceania", "https://flagcdn.com/pg.svg")
    );

    public List<Pais> listarTodos() {
        return paises;
    }

    public List<Pais> filtrarPorContinente(String continente) {
        if (continente == null || continente.isEmpty()) {
            return paises;
        }
        return paises.stream()
                .filter(p -> p.getContinente().equalsIgnoreCase(continente))
                .collect(Collectors.toList());
    }
}
