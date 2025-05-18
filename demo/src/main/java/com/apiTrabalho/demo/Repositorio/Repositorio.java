package com.apiTrabalho.demo.Repositorio;

import com.apiTrabalho.demo.Entidade.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repositorio  extends JpaRepository<Entidade,Integer> {

}
