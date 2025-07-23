package com.joseane.controlefinanceiro.repositories;

import com.joseane.controlefinanceiro.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("SELECT d FROM Despesa d WHERE MONTH(d.data) = :mes AND YEAR(d.data) = :ano")
    List<Despesa> findByMesEAno(@Param("ano") int ano, @Param("mes") int mes);
}
