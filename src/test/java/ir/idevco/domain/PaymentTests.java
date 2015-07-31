package ir.idevco.domain;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PaymentTests {
	private static final Person RECIPIENT = new Person("RECIPIENT");
	private static final Person PAYER = new Person("PERSON");
	private static final int AMOUNT = 1_000_000;
	private static final String DESCRIPTION = "Description";
	private static final String TITLE = "Title";

	@Test
	public void propertiesSettedAsExpected() {
		Payment payment = Payment.create().title(TITLE).description(DESCRIPTION).amount(AMOUNT).payer(PAYER)
				.recipient(RECIPIENT).build();

		assertThat(payment.getTitle(), is(TITLE));
		assertThat(payment.getDescription(), is(DESCRIPTION));
		assertThat(payment.getAmount(), is(AMOUNT));
		assertThat(payment.getPayer(), is(PAYER));
		assertThat(payment.getRecipient(), is(RECIPIENT));
	}

	@Test
	public void paymentTypeSettedCorrectly() {
		Payment payment = Payment.create().type(PaymentType.CASH).build();

		assertThat(payment.getType(), is(PaymentType.CASH));
	}
}
