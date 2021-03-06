package com.github.henrique.avaliacaojava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.henrique.avaliacaojava.models.AnoBimestre;


@Repository
public interface AnoBimestreRepository extends JpaRepository<AnoBimestre, Integer>{
	
	List<AnoBimestre> findAllByAno(Long ano);
	
}
