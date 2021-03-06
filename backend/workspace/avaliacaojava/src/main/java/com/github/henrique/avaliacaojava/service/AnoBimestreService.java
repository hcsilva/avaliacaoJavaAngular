package com.github.henrique.avaliacaojava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.github.henrique.avaliacaojava.dto.AnoBimestreDto;
import com.github.henrique.avaliacaojava.mapper.AnoBimestreMapper;
import com.github.henrique.avaliacaojava.models.AnoBimestre;
import com.github.henrique.avaliacaojava.repository.AnoBimestreRepository;
import com.github.henrique.avaliacaojava.util.LongConverter;

@Service
public class AnoBimestreService implements AnoBimestreMapper {

	@Autowired
	private AnoBimestreRepository anoBimestreRepository;

	@Autowired
	private LongConverter longConverter;

	private AnoBimestreMapper anoBimestreMapper;

	@Transactional
	public AnoBimestre save(AnoBimestreDto anoBimestreDto) {
		return anoBimestreRepository.save(anoBimestreMapper.toModel(anoBimestreDto));
	}

	@Transactional(readOnly = true)
	public AnoBimestre findById(Integer id) {
		return anoBimestreRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "AnoBimestre não encontrado"));
	}

	public void deletar(Integer id) {
		AnoBimestre anoBimestre = findById(id);
		anoBimestreRepository.delete(anoBimestre);
	}

	public void update(Integer id, AnoBimestreDto anoBimestreDtoNovo) {
		AnoBimestre anoBimestreSalvo = findById(id);
		AnoBimestre anoBimestre = anoBimestreMapper.toModel(anoBimestreDtoNovo);
		anoBimestre.setId(anoBimestreSalvo.getId());

		anoBimestreRepository.save(anoBimestre);
	}

	@Transactional(readOnly = true)
	public List<AnoBimestre> findAll() {
		return anoBimestreRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<AnoBimestre> findAll(Pageable pageable) {
		return anoBimestreRepository.findAll(pageable);
	}

	public List<AnoBimestre> findAllByAno(Long ano) {
		System.out.println("AQUI: "+anoBimestreRepository.findAllByAno(ano));
		return anoBimestreRepository.findAllByAno(ano);
	}

	public void gerarBimestresParaAno(String anoParametro) {
		Long ano = longConverter.converter(anoParametro);
		List<AnoBimestre> anoBimestres = new ArrayList<>();

		for (int i = 0; i != 4; i++) {
			AnoBimestre bimestre = new AnoBimestre();
			bimestre.setAno(ano);
			bimestre.setBimestre(i+1);

			anoBimestres.add(bimestre);
		}

		anoBimestreRepository.saveAll(anoBimestres);
	}

	@Override
	public AnoBimestre toModel(AnoBimestreDto anoBimestreDto) {
		if (anoBimestreDto == null) {
			return null;
		}

		AnoBimestre anoBimestre = new AnoBimestre();
		anoBimestre.setAno(longConverter.converter(anoBimestreDto.getAno()));
		anoBimestre.setBimestre(Integer.valueOf(anoBimestreDto.getBimestre()));

		return anoBimestre;
	}

	@Override
	public AnoBimestreDto toDto(AnoBimestre anoBimestre) {
		// TODO Auto-generated method stub
		return null;
	}

}
