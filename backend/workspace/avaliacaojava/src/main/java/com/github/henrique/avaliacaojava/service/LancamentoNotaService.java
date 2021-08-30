
package com.github.henrique.avaliacaojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.github.henrique.avaliacaojava.dto.LancamentoNotaDto;
import com.github.henrique.avaliacaojava.mapper.LancamentoNotaMapper;
import com.github.henrique.avaliacaojava.models.Aluno;
import com.github.henrique.avaliacaojava.models.LancamentoNota;
import com.github.henrique.avaliacaojava.repository.LancamentoNotaRepository;
import com.github.henrique.avaliacaojava.util.BigDecimalConverter;

@Service
public class LancamentoNotaService implements LancamentoNotaMapper {

	@Autowired
	private LancamentoNotaRepository lancamentoNotaRepository;

	@Autowired
	private LancamentoNotaMapper lancamentoNotaMapper;

	@Autowired
	private BigDecimalConverter bigDecimalConverter;

	@Transactional
	public LancamentoNota save(LancamentoNotaDto lancamentoNotaDto) {
		return lancamentoNotaRepository.save(lancamentoNotaMapper.toModel(lancamentoNotaDto));
	}

	@Transactional(readOnly = true)
	public LancamentoNota findById(Integer id) {
		return lancamentoNotaRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "LancamentoNota não encontrado"));
	}

	public void deletar(Integer id) {
		LancamentoNota lancamentoNota = findById(id);
		lancamentoNotaRepository.delete(lancamentoNota);
	}

	public void update(Integer id, LancamentoNotaDto lancamentoNotaDtoNovo) {
		LancamentoNota lancamentoNotaSalvo = findById(id);
		LancamentoNota lancamentoNota = lancamentoNotaMapper.toModel(lancamentoNotaDtoNovo);
		lancamentoNota.setId(lancamentoNotaSalvo.getId());

		lancamentoNotaRepository.save(lancamentoNota);
	}

	@Transactional(readOnly = true)
	public List<LancamentoNota> findAll() {
		return lancamentoNotaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<LancamentoNota> findAll(Pageable pageable) {
		return lancamentoNotaRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public List<LancamentoNota> findByAluno(Aluno aluno) {
		return lancamentoNotaRepository.findByAluno(aluno);
	}

	@Override
	public LancamentoNota toModel(LancamentoNotaDto lancamentoNotaDto) {
		if (lancamentoNotaDto == null) {
			return null;
		}

		LancamentoNota lancamento = new LancamentoNota();
		lancamento.setAluno(lancamentoNotaDto.getAluno());
		lancamento.setAnoBimestre(lancamentoNotaDto.getAnoBimestre());
		lancamento.setFaltas(Integer.valueOf(lancamentoNotaDto.getFaltas()));
		lancamento.setValorAvaliacao1(bigDecimalConverter.converter(lancamentoNotaDto.getValorAvaliacao1()));
		lancamento.setValorAvaliacao2(bigDecimalConverter.converter(lancamentoNotaDto.getValorAvaliacao2()));
		lancamento.setValorAvaliacao3(bigDecimalConverter.converter(lancamentoNotaDto.getValorAvaliacao3()));
		lancamento.setValorAvaliacao4(bigDecimalConverter.converter(lancamentoNotaDto.getValorAvaliacao4()));

		return lancamento;
	}

	@Override
	public LancamentoNotaDto toDto(LancamentoNota lancamentoNota) {
		// TODO Auto-generated method stub
		return null;
	}

}
