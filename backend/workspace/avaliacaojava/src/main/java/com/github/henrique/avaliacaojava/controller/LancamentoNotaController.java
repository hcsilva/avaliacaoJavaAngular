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

import com.github.henrique.avaliacaojava.dto.LancamentoNotaDto;
import com.github.henrique.avaliacaojava.models.LancamentoNota;
import com.github.henrique.avaliacaojava.service.LancamentoNotaService;

@RestController
@RequestMapping("api/lancamentoNota")
public class LancamentoNotaController {

	@Autowired
	private LancamentoNotaService lancamentoNotaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LancamentoNota salvar(@RequestBody @Valid LancamentoNotaDto lancamentoNotaDto) {
		return lancamentoNotaService.save(lancamentoNotaDto);
	}

	@GetMapping("{id}")
	public LancamentoNota findById(@PathVariable(value = "id") Integer id) {
		return lancamentoNotaService.findById(id);
	}

	@GetMapping(value = "/findAll")
	public List<LancamentoNota> findAll() {
		return lancamentoNotaService.findAll();
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Integer id) {
		lancamentoNotaService.deletar(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(value = "id") Integer id, @RequestBody @Valid LancamentoNotaDto lancamentoNotaDto) {
		lancamentoNotaService.update(id, lancamentoNotaDto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<LancamentoNota> list(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {

		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
		return lancamentoNotaService.findAll(pageRequest);
	}

}
