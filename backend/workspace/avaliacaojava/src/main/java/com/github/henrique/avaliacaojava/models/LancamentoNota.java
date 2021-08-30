package com.github.henrique.avaliacaojava.models;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LANCAMENTO_NOTA")
public class LancamentoNota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ID_ALUNO")
	Aluno aluno;

	@Column(name = "faltas")
	Integer faltas;

	@Column(name = "valor_avaliacao_1")
	BigDecimal valorAvaliacao1;

	@Column(name = "valor_avaliacao_2")
	BigDecimal valorAvaliacao2;

	@Column(name = "valor_avaliacao_3")
	BigDecimal valorAvaliacao3;

	@Column(name = "valor_avaliacao_4")
	BigDecimal valorAvaliacao4;

	@ManyToOne
	@JoinColumn(name = "ID_ANO_BIMESTRE")
	AnoBimestre anoBimestre;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	public BigDecimal getValorAvaliacao1() {
		return valorAvaliacao1;
	}

	public void setValorAvaliacao1(BigDecimal valorAvaliacao1) {
		this.valorAvaliacao1 = valorAvaliacao1;
	}

	public BigDecimal getValorAvaliacao2() {
		return valorAvaliacao2;
	}

	public void setValorAvaliacao2(BigDecimal valorAvaliacao2) {
		this.valorAvaliacao2 = valorAvaliacao2;
	}

	public BigDecimal getValorAvaliacao3() {
		return valorAvaliacao3;
	}

	public void setValorAvaliacao3(BigDecimal valorAvaliacao3) {
		this.valorAvaliacao3 = valorAvaliacao3;
	}

	public BigDecimal getValorAvaliacao4() {
		return valorAvaliacao4;
	}

	public void setValorAvaliacao4(BigDecimal valorAvaliacao4) {
		this.valorAvaliacao4 = valorAvaliacao4;
	}

	public AnoBimestre getAnoBimestre() {
		return anoBimestre;
	}

	public void setAnoBimestre(AnoBimestre anoBimestre) {
		this.anoBimestre = anoBimestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, anoBimestre, faltas, id, valorAvaliacao1, valorAvaliacao2, valorAvaliacao3,
				valorAvaliacao4);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LancamentoNota other = (LancamentoNota) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(anoBimestre, other.anoBimestre)
				&& Objects.equals(faltas, other.faltas) && Objects.equals(id, other.id)
				&& Objects.equals(valorAvaliacao1, other.valorAvaliacao1)
				&& Objects.equals(valorAvaliacao2, other.valorAvaliacao2)
				&& Objects.equals(valorAvaliacao3, other.valorAvaliacao3)
				&& Objects.equals(valorAvaliacao4, other.valorAvaliacao4);
	}

}
