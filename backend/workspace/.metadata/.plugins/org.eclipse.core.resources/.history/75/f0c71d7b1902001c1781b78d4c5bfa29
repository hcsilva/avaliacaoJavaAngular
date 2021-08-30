package br.com.keyworks.funworks.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {

	public String formatLocalDateTimeToBaseStyle(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(localDateTime);
	}

}
