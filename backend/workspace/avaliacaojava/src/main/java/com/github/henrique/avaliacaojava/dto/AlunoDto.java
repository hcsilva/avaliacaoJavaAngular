package com.github.henrique.avaliacaojava.dto;

import javax.validation.constraints.NotEmpty;

public class AlunoDto {

	@NotEmpty(message = "{aluno.descricao.campoObrigatorio}")
	private String nome;

	private String situacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
