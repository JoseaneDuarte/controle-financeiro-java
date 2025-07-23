package com.joseane.controlefinanceiro.dtos;

import java.math.BigDecimal;
import java.util.List;
import com.joseane.controlefinanceiro.models.Receita;
import com.joseane.controlefinanceiro.models.Despesa;

public class RelatorioMensalDTO {
    private String mes;
    private BigDecimal totalReceitas;
    private BigDecimal totalDespesas;
    private BigDecimal saldo;
    private List<Receita> receitas;
    private List<Despesa> despesas;

    public RelatorioMensalDTO(String mes, BigDecimal totalReceitas, BigDecimal totalDespesas,
                               BigDecimal saldo, List<Receita> receitas, List<Despesa> despesas) {
        this.mes = mes;
        this.totalReceitas = totalReceitas;
        this.totalDespesas = totalDespesas;
        this.saldo = saldo;
        this.receitas = receitas;
        this.despesas = despesas;
    }

    // Getters
    public String getMes() { return mes; }
    public BigDecimal getTotalReceitas() { return totalReceitas; }
    public BigDecimal getTotalDespesas() { return totalDespesas; }
    public BigDecimal getSaldo() { return saldo; }
    public List<Receita> getReceitas() { return receitas; }
    public List<Despesa> getDespesas() { return despesas; }
}
