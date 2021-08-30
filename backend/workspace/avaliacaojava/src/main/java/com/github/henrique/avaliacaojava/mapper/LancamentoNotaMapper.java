package com.github.henrique.avaliacaojava.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.github.henrique.avaliacaojava.dto.LancamentoNotaDto;
import com.github.henrique.avaliacaojava.models.LancamentoNota;

@Mapper(componentModel = "spring")
public interface LancamentoNotaMapper {
	LancamentoNotaMapper INSTANCE = Mappers.getMapper(LancamentoNotaMapper.class);

	LancamentoNota toModel(LancamentoNotaDto lancamentoNotaDto);

	LancamentoNotaDto toDto(LancamentoNota lancamentoNota);
}
