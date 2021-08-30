package com.github.henrique.avaliacaojava.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.github.henrique.avaliacaojava.dto.AnoBimestreDto;
import com.github.henrique.avaliacaojava.models.AnoBimestre;

@Mapper(componentModel = "spring")
public interface AnoBimestreMapper {
	AnoBimestreMapper INSTANCE = Mappers.getMapper(AnoBimestreMapper.class);
	
	AnoBimestre toModel(AnoBimestreDto anoBimestreDto);
	
	AnoBimestreDto toDto(AnoBimestre anoBimestre);
}
