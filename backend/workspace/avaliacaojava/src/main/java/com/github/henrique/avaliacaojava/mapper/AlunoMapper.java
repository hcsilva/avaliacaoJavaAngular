package com.github.henrique.avaliacaojava.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.github.henrique.avaliacaojava.dto.AlunoDto;
import com.github.henrique.avaliacaojava.models.Aluno;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
	AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);
	
	Aluno toModel(AlunoDto alunoDto);
	
	AlunoDto toDto(Aluno aluno);
}
