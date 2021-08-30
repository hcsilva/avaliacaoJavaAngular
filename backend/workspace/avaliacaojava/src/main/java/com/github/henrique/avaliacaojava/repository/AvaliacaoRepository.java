package com.github.henrique.avaliacaojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.henrique.avaliacaojava.models.Avaliacao;


@Repository
public interface AvaliacaoRepository  extends JpaRepository<Avaliacao, Integer>{

}
