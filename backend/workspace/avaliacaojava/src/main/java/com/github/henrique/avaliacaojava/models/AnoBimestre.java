package com.github.henrique.avaliacaojava.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANO_BIMESTRE")
public class AnoBimestre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ANO")
	Long ano;

	@Column(name = "BIMESTRE")
	Integer bimestre;

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Integer getBimestre() {
		return bimestre;
	}

	public void setBimestre(Integer bimestre) {
		this.bimestre = bimestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, bimestre, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnoBimestre other = (AnoBimestre) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(bimestre, other.bimestre)
				&& Objects.equals(id, other.id);
	}

}
