package ir.idevco.infrastructure.converter;

import java.io.IOException;
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
		return LocalDateTime.parse(dateAsString.substring(1, dateAsString.length() - 1), DateTimeFormatter.ISO_DATE_TIME);
	}

}
