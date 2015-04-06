package ir.idevco.infrastructure;

import ir.idevco.infrastructure.converter.DateToLocalDateTimeConverter;
import ir.idevco.infrastructure.converter.LocalDateTimeToDateConverter;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoAuditing
public class MongoDBConfig extends AbstractMongoConfiguration {

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#customConversions()
	 */
	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(Arrays.asList(new LocalDateTimeToDateConverter(), new DateToLocalDateTimeConverter()));
	}

	@Override
	protected String getDatabaseName() {
		return "test";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}

}
