package com.joseane.controlefinanceiro.repositories;

import com.joseane.controlefinanceiro.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query("SELECT r FROM Receita r WHERE MONTH(r.data) = :mes AND YEAR(r.data) = :ano")
    List<Receita> findByMesEAno(@Param("ano") int ano, @Param("mes") int mes);
}
