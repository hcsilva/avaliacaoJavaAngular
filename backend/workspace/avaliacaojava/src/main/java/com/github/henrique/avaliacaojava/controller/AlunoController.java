package com.github.henrique.avaliacaojava.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.henrique.avaliacaojava.dto.AlunoDto;
import com.github.henrique.avaliacaojava.models.Aluno;
import com.github.henrique.avaliacaojava.service.AlunoService;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno salvar(@RequestBody @Valid AlunoDto alunoDto) {
		return alunoService.save(alunoDto);
	}

	@GetMapping("{id}")
	public Aluno findById(@PathVariable(value = "id") Integer id) {
		return alunoService.findById(id);
	}

	@GetMapping(value = "/findAll")
	public List<Aluno> findAll() {
		return alunoService.findAll();
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Integer id) {
		alunoService.deletar(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(value = "id") Integer id, @RequestBody @Valid AlunoDto alunoDto) {
		alunoService.update(id, alunoDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Aluno> list(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {

		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
		return alunoService.findAll(pageRequest);
	}

	@PostMapping(value = "/calcularNota/ano/{ano}/aluno/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void gerarBimestresParaAno(@PathVariable(value = "ano") String ano, @PathVariable(value = "id") Integer id) {
		Long anoNumerico = Long.valueOf(ano);
		alunoService.realizarCalculoSituacaoAluno(anoNumerico, id);
	}
}
