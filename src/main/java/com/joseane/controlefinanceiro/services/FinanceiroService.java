package com.joseane.controlefinanceiro.services;

import com.joseane.controlefinanceiro.dtos.RelatorioMensalDTO;
import com.joseane.controlefinanceiro.models.Receita;
import com.joseane.controlefinanceiro.models.Despesa;
import com.joseane.controlefinanceiro.repositories.ReceitaRepository;
import com.joseane.controlefinanceiro.repositories.DespesaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FinanceiroService {

    private final ReceitaRepository receitaRepository;
    private final DespesaRepository despesaRepository;

    public FinanceiroService(ReceitaRepository receitaRepository, DespesaRepository despesaRepository) {
        this.receitaRepository = receitaRepository;
        this.despesaRepository = despesaRepository;
    }

    public BigDecimal calcularTotalReceitas() {
        return receitaRepository.findAll()
                .stream()
                .map(Receita::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularTotalDespesas() {
        return despesaRepository.findAll()
                .stream()
                .map(Despesa::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calcularSaldoFinal() {
        return calcularTotalReceitas().subtract(calcularTotalDespesas());
    }

    public RelatorioMensalDTO gerarRelatorioMensal(int ano, int mes) {
        List<Receita> receitasDoMes = receitaRepository.findByMesEAno(ano, mes);
        List<Despesa> despesasDoMes = despesaRepository.findByMesEAno(ano, mes);

        BigDecimal totalReceitas = receitasDoMes.stream()
                .map(Receita::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesas = despesasDoMes.stream()
                .map(Despesa::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldo = totalReceitas.subtract(totalDespesas);
        String nomeMes = String.format("%02d/%d", mes, ano); // exemplo: "07/2025"

        return new RelatorioMensalDTO(nomeMes, totalReceitas, totalDespesas, saldo, receitasDoMes, despesasDoMes);
    }
}
