package com.jandir.paises.service;

import com.jandir.paises.model.Pais;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaisService {

    private List<Pais> paises = new ArrayList<>();
    private Map<String, Pais> mapaPaises = new HashMap<>();

    @PostConstruct
    public void init() {
        // América do Sul
        paises.add(new Pais("Brasil", "Brasília", "América do Sul", "https://flagcdn.com/br.svg"));
        paises.add(new Pais("Argentina", "Buenos Aires", "América do Sul", "https://flagcdn.com/ar.svg"));
        paises.add(new Pais("Colômbia", "Bogotá", "América do Sul", "https://flagcdn.com/co.svg"));
        paises.add(new Pais("Peru", "Lima", "América do Sul", "https://flagcdn.com/pe.svg"));
        paises.add(new Pais("Chile", "Santiago", "América do Sul", "https://flagcdn.com/cl.svg"));

        // América do Norte
        paises.add(new Pais("Estados Unidos", "Washington, D.C.", "América do Norte", "https://flagcdn.com/us.svg"));
        paises.add(new Pais("Canadá", "Ottawa", "América do Norte", "https://flagcdn.com/ca.svg"));
        paises.add(new Pais("México", "Cidade do México", "América do Norte", "https://flagcdn.com/mx.svg"));
        paises.add(new Pais("Cuba", "Havana", "América do Norte", "https://flagcdn.com/cu.svg"));
        paises.add(new Pais("Honduras", "Tegucigalpa", "América do Norte", "https://flagcdn.com/hn.svg"));

        // Europa
        paises.add(new Pais("França", "Paris", "Europa", "https://flagcdn.com/fr.svg"));
        paises.add(new Pais("Alemanha", "Berlim", "Europa", "https://flagcdn.com/de.svg"));
        paises.add(new Pais("Itália", "Roma", "Europa", "https://flagcdn.com/it.svg"));
        paises.add(new Pais("Espanha", "Madri", "Europa", "https://flagcdn.com/es.svg"));
        paises.add(new Pais("Portugal", "Lisboa", "Europa", "https://flagcdn.com/pt.svg"));

        // Ásia
        paises.add(new Pais("Japão", "Tóquio", "Ásia", "https://flagcdn.com/jp.svg"));
        paises.add(new Pais("China", "Pequim", "Ásia", "https://flagcdn.com/cn.svg"));
        paises.add(new Pais("Índia", "Nova Deli", "Ásia", "https://flagcdn.com/in.svg"));
        paises.add(new Pais("Coreia do Sul", "Seul", "Ásia", "https://flagcdn.com/kr.svg"));
        paises.add(new Pais("Indonésia", "Jacarta", "Ásia", "https://flagcdn.com/id.svg"));

        // África
        paises.add(new Pais("Egito", "Cairo", "África", "https://flagcdn.com/eg.svg"));
        paises.add(new Pais("Nigéria", "Abuja", "África", "https://flagcdn.com/ng.svg"));
        paises.add(new Pais("África do Sul", "Pretória", "África", "https://flagcdn.com/za.svg"));
        paises.add(new Pais("Quênia", "Nairóbi", "África", "https://flagcdn.com/ke.svg"));
        paises.add(new Pais("Marrocos", "Rabat", "África", "https://flagcdn.com/ma.svg"));

        // Oceania
        paises.add(new Pais("Austrália", "Camberra", "Oceania", "https://flagcdn.com/au.svg"));
        paises.add(new Pais("Nova Zelândia", "Wellington", "Oceania", "https://flagcdn.com/nz.svg"));
        paises.add(new Pais("Fiji", "Suva", "Oceania", "https://flagcdn.com/fj.svg"));
        paises.add(new Pais("Samoa", "Apia", "Oceania", "https://flagcdn.com/ws.svg"));
        paises.add(new Pais("Papua Nova Guiné", "Port Moresby", "Oceania", "https://flagcdn.com/pg.svg"));

        for (Pais pais : paises) {
            mapaPaises.put(pais.getNome().toLowerCase(), pais);
        }
    }

    private void adicionarPais(Pais pais) {
        paises.add(pais);
        mapaPaises.put(pais.getNome().toLowerCase(), pais);
    }

    public List<Pais> listarTodos() {
        // Ordena a lista de países por nome (ignorando maiúsculas/minúsculas)
        List<Pais> sortedPaises = new ArrayList<>(paises); // Cria uma cópia para não modificar a lista original
        sortedPaises.sort(Comparator.comparing(Pais::getNome, String.CASE_INSENSITIVE_ORDER));
        return sortedPaises;
    }

    public List<Pais> filtrarPorContinentes(List<String> continentes) {
        List<Pais> filteredAndSortedPaises;
        if (continentes == null || continentes.isEmpty()) {
            filteredAndSortedPaises = new ArrayList<>(paises); // Filtro vazio, pega todos
        } else {
            Set<String> lowerContinentes = continentes.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());
            filteredAndSortedPaises = paises.stream()
                    .filter(p -> lowerContinentes.contains(p.getContinente().toLowerCase()))
                    .collect(Collectors.toList());
        }
        // Aplica a ordenação também aos resultados filtrados
        filteredAndSortedPaises.sort(Comparator.comparing(Pais::getNome, String.CASE_INSENSITIVE_ORDER));
        return filteredAndSortedPaises;
    }

    public Optional<Pais> buscarPorNome(String nome) {
        if (nome == null) return Optional.empty();
        return Optional.ofNullable(mapaPaises.get(nome.toLowerCase()));
    }

    public void salvar(Pais pais) {
        Optional<Pais> existente = buscarPorNome(pais.getNome());
        if (existente.isPresent()) {
            Pais p = existente.get();
            p.setCapital(pais.getCapital());
            p.setContinente(pais.getContinente());
            p.setBandeiraUrl(pais.getBandeiraUrl());
        } else {
            adicionarPais(pais);
        }
    }

    public void deletarPorNome(String nome) {
        Optional<Pais> opc = buscarPorNome(nome);
        opc.ifPresent(pais -> {
            paises.remove(pais);
            mapaPaises.remove(nome.toLowerCase());
        });
    }

    public Optional<Pais> autocomplete(String nome) {
        return buscarPorNome(nome); // Esta ainda busca na lista interna
    }
}