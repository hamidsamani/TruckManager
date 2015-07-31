package ir.idevco.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ir.idevco.AbstractContextConfiguration;
import ir.idevco.domain.Payment;

public class PaymentServiceTests extends AbstractContextConfiguration {

	private static final String OLD_TITLE = "oldTitle";
	private static final String NEW_TITLE = "newTitle";
	@Autowired
	private PaymentService paymentService;

	@Test
	public void paymentUpdatedSucessfully() {
		Payment payment = Payment.create().title(OLD_TITLE).build();

		assertThat(payment.getTitle(), is(OLD_TITLE));

		Payment oldPayment = paymentService.save(payment);

		oldPayment.setTitle(NEW_TITLE);

		Payment newPayment = paymentService.save(oldPayment);

		assertThat(newPayment.getTitle(), is(NEW_TITLE));

	}

	@Test
	public void paymentDateRangeReturnsSucessfully() {
		List<Payment> list = paymentService.findByDateBetween(LocalDateTime.now().minusDays(5), LocalDateTime.now()
				.plusDays(1));
		for (Payment p : list) {
			System.out.println(p);
		}
	}

	@Test
	public void paymentCreatedDateRangeReturnsSucessfully() {
		List<Payment> list = paymentService.findByCreatedDateBetween(LocalDateTime.now().minusDays(5), LocalDateTime.now()
				.minusDays(1));
		for (Payment p : list) {
			System.out.println(p);
		}
	}

	@Test
	public void insertPaymentsIntoMongo() {
		clearAllPayments();
		paymentService.save(Payment.create().date(LocalDateTime.now().minusDays(2)).build());
		paymentService.save(Payment.create().date(LocalDateTime.now().minusDays(1)).build());

		paymentService.save(Payment.create().date(LocalDateTime.now()).build());

		List<Payment> result = paymentService.findByDateBetween(LocalDateTime.now().minusDays(2), LocalDateTime.now()
				.minusDays(1));

		result.forEach(System.out::println);

	}

	private void clearAllPayments() {
		paymentService.deleteAll();

	}
}
