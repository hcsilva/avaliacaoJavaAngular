package com.github.henrique.avaliacaojava.dto;

import javax.validation.constraints.NotNull;

import com.github.henrique.avaliacaojava.models.Aluno;
import com.github.henrique.avaliacaojava.models.AnoBimestre;

public class LancamentoNotaDto {

	@NotNull(message = "{lancamentoNota.aluno.campoObrigatorio}")
	Aluno aluno;

	@NotNull(message = "{lancamentoNota.faltas.campoObrigatorio}")
	String faltas;

	@NotNull(message = "{lancamentoNota.valorAvaliacao1.campoObrigatorio}")
	String valorAvaliacao1;

	@NotNull(message = "{lancamentoNota.valorAvaliacao2.campoObrigatorio}")
	String valorAvaliacao2;

	@NotNull(message = "{lancamentoNota.valorAvaliacao4.campoObrigatorio}")
	String valorAvaliacao3;

	@NotNull(message = "{lancamentoNota.valorAvaliacao4.campoObrigatorio}")
	String valorAvaliacao4;

	@NotNull(message = "{lancamentoNota.anoBimestre.campoObrigatorio}")
	AnoBimestre anoBimestre;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getFaltas() {
		return faltas;
	}

	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}

	public String getValorAvaliacao1() {
		return valorAvaliacao1;
	}

	public void setValorAvaliacao1(String valorAvaliacao1) {
		this.valorAvaliacao1 = valorAvaliacao1;
	}

	public String getValorAvaliacao2() {
		return valorAvaliacao2;
	}

	public void setValorAvaliacao2(String valorAvaliacao2) {
		this.valorAvaliacao2 = valorAvaliacao2;
	}

	public String getValorAvaliacao3() {
		return valorAvaliacao3;
	}

	public void setValorAvaliacao3(String valorAvaliacao3) {
		this.valorAvaliacao3 = valorAvaliacao3;
	}

	public String getValorAvaliacao4() {
		return valorAvaliacao4;
	}

	public void setValorAvaliacao4(String valorAvaliacao4) {
		this.valorAvaliacao4 = valorAvaliacao4;
	}

	public AnoBimestre getAnoBimestre() {
		return anoBimestre;
	}

	public void setAnoBimestre(AnoBimestre anoBimestre) {
		this.anoBimestre = anoBimestre;
	}

}
