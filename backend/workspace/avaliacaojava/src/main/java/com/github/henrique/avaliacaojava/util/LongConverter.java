package com.github.henrique.avaliacaojava.util;

import org.springframework.stereotype.Component;

@Component
public class LongConverter {

	public Long converter(String value) {
		if (value == null) {
			return null;
		}

		return Long.valueOf(value);
	}

}
