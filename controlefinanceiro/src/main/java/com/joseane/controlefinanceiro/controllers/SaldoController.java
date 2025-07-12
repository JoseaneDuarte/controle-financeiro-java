package com.joseane.controlefinanceiro.controllers;

import com.joseane.controlefinanceiro.services.FinanceiroService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/saldo")
public class SaldoController {

    private final FinanceiroService financeiroService;

    public SaldoController(FinanceiroService financeiroService) {
        this.financeiroService = financeiroService;
    }

    @GetMapping
    public Map<String, BigDecimal> consultarSaldo() {
        BigDecimal receitas = financeiroService.calcularTotalReceitas();
        BigDecimal despesas = financeiroService.calcularTotalDespesas();
        BigDecimal saldo = financeiroService.calcularSaldoFinal();

        return Map.of(
            "totalReceitas", receitas,
            "totalDespesas", despesas,
            "saldo", saldo
        );
    }
}
