package com.github.henrique.avaliacaojava.dto;

import javax.validation.constraints.NotEmpty;

public class AnoBimestreDto {

	@NotEmpty(message = "anoBimestre.ano.campoObrigatorio")
	private String ano;

	@NotEmpty(message = "anoBimestre.bimestre.campoObrigatorio")
	private String bimestre;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

}
