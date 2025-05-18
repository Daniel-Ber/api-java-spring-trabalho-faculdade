package com.apiTrabalho.demo.Repositorio;


import com.apiTrabalho.demo.Entidade.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Repositorio extends JpaRepository<Entidade, Integer> {
    List<Entidade> findByNomeStartingWithAndIdadeGreaterThan(String nome, Integer idade);
    List<Entidade> findByNomeAndIdadeGreaterThan(String nome, Integer idade);
}
