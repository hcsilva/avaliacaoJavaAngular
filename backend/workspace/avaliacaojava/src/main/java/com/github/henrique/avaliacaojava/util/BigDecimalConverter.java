package com.github.henrique.avaliacaojava.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConverter {

	public BigDecimal converter(String value) {
		if (value == null) {
			return null;
		}

		value = value.replace(",", ".");
		return new BigDecimal(value);
	}

}
