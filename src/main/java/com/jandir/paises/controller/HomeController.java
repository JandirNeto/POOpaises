package com.jandir.paises.controller;

import com.jandir.paises.model.Pais;
import com.jandir.paises.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToPaisList() {
        return "redirect:/pais/";
    }
}
