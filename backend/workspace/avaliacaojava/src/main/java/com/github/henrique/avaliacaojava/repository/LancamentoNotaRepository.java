package com.github.henrique.avaliacaojava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.henrique.avaliacaojava.models.Aluno;
import com.github.henrique.avaliacaojava.models.LancamentoNota;

@Repository
public interface LancamentoNotaRepository extends JpaRepository<LancamentoNota, Integer> {

	List<LancamentoNota> findByAluno(Aluno aluno);

}
