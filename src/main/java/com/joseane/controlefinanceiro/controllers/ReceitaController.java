package com.joseane.controlefinanceiro.controllers;

import com.joseane.controlefinanceiro.models.Receita;
import com.joseane.controlefinanceiro.repositories.ReceitaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaRepository receitaRepository;

    public ReceitaController(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @PostMapping
    public Receita cadastrarReceita(@RequestBody Receita receita) {
        return receitaRepository.save(receita);
    }

    @GetMapping
    public List<Receita> listarReceitas() {
        return receitaRepository.findAll();
    }
}
