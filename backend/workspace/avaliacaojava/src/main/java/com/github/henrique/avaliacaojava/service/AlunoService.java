package com.github.henrique.avaliacaojava.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import com.github.henrique.avaliacaojava.dto.AlunoDto;
import com.github.henrique.avaliacaojava.mapper.AlunoMapper;
import com.github.henrique.avaliacaojava.models.Aluno;
import com.github.henrique.avaliacaojava.models.LancamentoNota;
import com.github.henrique.avaliacaojava.repository.AlunoRepository;

@Service
public class AlunoService implements AlunoMapper {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private LancamentoNotaService lancamentoNotaService;

	@Autowired
	private AlunoMapper alunoMapper;

	@Transactional
	public Aluno save(AlunoDto alunoDto) {
		return alunoRepository.save(alunoMapper.toModel(alunoDto));
	}

	@Transactional(readOnly = true)
	public Aluno findById(Integer id) {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
	}

	public void deletar(Integer id) {
		Aluno aluno = findById(id);
		alunoRepository.delete(aluno);
	}

	public void update(Integer id, AlunoDto alunoDtoNovo) {
		Aluno alunoSalvo = findById(id);
		Aluno aluno = alunoMapper.toModel(alunoDtoNovo);
		aluno.setId(alunoSalvo.getId());

		alunoRepository.save(aluno);
	}

	@Transactional(readOnly = true)
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Aluno> findAll(Pageable pageable) {
		return alunoRepository.findAll(pageable);
	}

	public void realizarCalculoSituacaoAluno(Long ano, Integer id) {
		Aluno aluno = findById(id);
		List<LancamentoNota> notas = lancamentoNotaService.findByAluno(aluno);
		BigDecimal notaSomaTotal = BigDecimal.ZERO;
		BigDecimal mediaFinal = BigDecimal.ZERO;
		Integer faltasTotais = 0;
		String situacaoAluno = "";

		if (!CollectionUtils.isEmpty(notas)) {
			for (LancamentoNota nota : notas) {
				faltasTotais += nota.getFaltas();

				notaSomaTotal = notaSomaTotal.add(nota.getValorAvaliacao1());
				notaSomaTotal = notaSomaTotal.add(nota.getValorAvaliacao2());
				notaSomaTotal = notaSomaTotal.add(nota.getValorAvaliacao3());
				notaSomaTotal = notaSomaTotal.add(nota.getValorAvaliacao4());
			}

			mediaFinal = notaSomaTotal.divide(new BigDecimal(4), RoundingMode.HALF_EVEN);
		}

		situacaoAluno = getSituacaoAluno(mediaFinal, faltasTotais);
		aluno.setSituacao(situacaoAluno);
		alunoRepository.save(aluno);
	}

	private String getSituacaoAluno(BigDecimal mediaFinal, Integer faltas) {
		BigDecimal percentualPresenca = BigDecimal.ZERO;

		if (faltas == 0) {
			percentualPresenca = new BigDecimal(100);
		} else {
			percentualPresenca = new BigDecimal((faltas * 100) / 160);
			percentualPresenca = new BigDecimal(100).subtract(percentualPresenca);
		}

		if (percentualPresenca.compareTo(new BigDecimal(75)) >= 0 && mediaFinal.compareTo(new BigDecimal(6)) >= 0) {
			return "APROVADO";
		}

		if (percentualPresenca.compareTo(new BigDecimal(75)) < 0 || mediaFinal.compareTo(new BigDecimal(5)) < 0) {
			return "REPROVADO";
		}

		if (mediaFinal.compareTo(new BigDecimal(5)) >= 0 && mediaFinal.compareTo(new BigDecimal(6)) < 0) {
			return "RECUPERAÇÃO";
		}

		return "";
	}

	@Override
	public Aluno toModel(AlunoDto alunoDto) {
		if (alunoDto == null) {
			return null;
		}

		Aluno aluno = new Aluno();
		aluno.setNome(alunoDto.getNome());

		if (alunoDto.getSituacao() != null && !alunoDto.getSituacao().isEmpty()) {
			aluno.setSituacao(alunoDto.getSituacao());
		}

		return aluno;
	}

	@Override
	public AlunoDto toDto(Aluno aluno) {
		// TODO Auto-generated method stub
		return null;
	}

}
