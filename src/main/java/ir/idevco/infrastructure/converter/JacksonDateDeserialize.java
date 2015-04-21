package ir.idevco.infrastructure.converter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JacksonDateDeserialize extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
			JsonProcessingException {

		String dateAsString = jp.getCodec().readTree(jp).toString();
		return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("\"MM/dd/uuuu\"")).atStartOfDay();
	}

}
