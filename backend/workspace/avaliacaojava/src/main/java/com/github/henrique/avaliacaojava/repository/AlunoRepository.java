package com.github.henrique.avaliacaojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.henrique.avaliacaojava.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
