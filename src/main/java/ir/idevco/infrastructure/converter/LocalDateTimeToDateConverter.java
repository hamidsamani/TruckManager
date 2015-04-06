package ir.idevco.infrastructure.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class LocalDateTimeToDateConverter implements Converter<LocalDateTime, Date> {

	@Override
	public Date convert(LocalDateTime source) {
		
		return Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
	}

}
