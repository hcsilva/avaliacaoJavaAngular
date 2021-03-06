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

import com.github.henrique.avaliacaojava.dto.AnoBimestreDto;
import com.github.henrique.avaliacaojava.models.AnoBimestre;
import com.github.henrique.avaliacaojava.service.AnoBimestreService;
import com.github.henrique.avaliacaojava.util.LongConverter;

@RestController
@RequestMapping("api/anoBimestre")
public class AnoBimestreController {

	@Autowired
	private AnoBimestreService anoBimestreService;

	@Autowired
	private LongConverter longConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AnoBimestre salvar(@RequestBody @Valid AnoBimestreDto anoBimestreDto) {
		return anoBimestreService.save(anoBimestreDto);
	}

	@GetMapping("{id}")
	public AnoBimestre findById(@PathVariable(value = "id") Integer id) {
		return anoBimestreService.findById(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Integer id) {
		anoBimestreService.deletar(id);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable(value = "id") Integer id, @RequestBody @Valid AnoBimestreDto anoBimestreDto) {
		anoBimestreService.update(id, anoBimestreDto);
	}

	@GetMapping(value = "/findAno/{ano}")
	@ResponseStatus(HttpStatus.OK)
	public List<AnoBimestre> findAllByAno(@PathVariable(value = "ano") String ano) {
		Long anoNumber = longConverter.converter(ano);
		return anoBimestreService.findAllByAno(anoNumber);
	}

	@PostMapping(value = "/gerarBimestres/{ano}")
	@ResponseStatus(HttpStatus.CREATED)
	public void gerarBimestresParaAno(@PathVariable(value = "ano") String ano) {
		anoBimestreService.gerarBimestresParaAno(ano);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<AnoBimestre> list(@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina) {

		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina, sort);
		return anoBimestreService.findAll(pageRequest);

	}

}
