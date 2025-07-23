package com.joseane.controlefinanceiro.controllers;

import com.joseane.controlefinanceiro.models.Despesa;
import com.joseane.controlefinanceiro.repositories.DespesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaRepository despesaRepository;

    public DespesaController(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    @PostMapping
    public Despesa cadastrarDespesa(@RequestBody Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    @GetMapping
    public List<Despesa> listarDespesas() {
        return despesaRepository.findAll();
    }
}
