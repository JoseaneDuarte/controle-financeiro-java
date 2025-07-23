package com.joseane.controlefinanceiro.controllers;

import com.joseane.controlefinanceiro.services.FinanceiroService;
import com.joseane.controlefinanceiro.dtos.RelatorioMensalDTO;
import com.joseane.controlefinanceiro.models.Despesa;
import com.joseane.controlefinanceiro.models.Receita;

import jakarta.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Controller
@RequestMapping("/relatorio/view")
public class RelatorioController {

    private final FinanceiroService financeiroService;
    private final TemplateEngine templateEngine;

    public RelatorioController(FinanceiroService financeiroService, TemplateEngine templateEngine) {
        this.financeiroService = financeiroService;
        this.templateEngine = templateEngine;
    }

    // 🟩 Relatório oficial com dados reais do banco
    @GetMapping("/{ano}/{mes}")
    public String exibirRelatorioHTML(@PathVariable int ano, @PathVariable int mes, Model model) {
        RelatorioMensalDTO relatorio = financeiroService.gerarRelatorioMensal(ano, mes);
        model.addAttribute("relatorio", relatorio);
        return "relatorio";
    }

    // 🧪 Relatório com dados fictícios para testar o HTML
    @GetMapping("/simulado")
    public String relatorioSimulado(Model model) {
        Receita receita = new Receita();
        receita.setDescricao("Salário");
        receita.setValor(new BigDecimal("3500.00"));
        receita.setData(LocalDate.of(2025, 7, 15));

        Despesa despesa = new Despesa();
        despesa.setDescricao("Aluguel");
        despesa.setValor(new BigDecimal("1200.00"));
        despesa.setData(LocalDate.of(2025, 7, 8));

        List<Receita> receitas = List.of(receita);
        List<Despesa> despesas = List.of(despesa);

        RelatorioMensalDTO relatorio = new RelatorioMensalDTO(
            "07/2025",
            new BigDecimal("3500.00"),
            new BigDecimal("1200.00"),
            new BigDecimal("2300.00"),
            receitas,
            despesas
        );

        model.addAttribute("relatorio", relatorio);
        return "relatorio";
    }

    // 📄 Gerar o PDF do relatório usando o mesmo HTML
    @GetMapping("/pdf/{ano}/{mes}")
    public void gerarPdfRelatorio(@PathVariable int ano,
                                  @PathVariable int mes,
                                  HttpServletResponse response) throws Exception {
        RelatorioMensalDTO relatorio = financeiroService.gerarRelatorioMensal(ano, mes);

        Context context = new Context();
        context.setVariable("relatorio", relatorio);

        String htmlContent = templateEngine.process("relatorio", context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=relatorio.pdf");

        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withHtmlContent(htmlContent, "");
        builder.toStream(response.getOutputStream());
        builder.run();
    }
}
