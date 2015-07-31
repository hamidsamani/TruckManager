package ir.idevco.service;

import static java.lang.String.*;
import ir.idevco.domain.Payment;
import ir.idevco.exception.PaymentNotFoundException;
import ir.idevco.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	private PaymentRepository paymentRepository;

	/**
	 * @param paymentRepository
	 */
	@Autowired
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	public Payment findOne(String id) {

		Payment findOne = paymentRepository.findOne(id);

		if (null == findOne) {
			throw new PaymentNotFoundException(format("given id: %s not found.", id));
		}
		return findOne;

	}

	public List<Payment> findByDateBetween(LocalDateTime from, LocalDateTime to) {
		List<Payment> payments = paymentRepository.findByDateBetween(from, to);
		if (payments.isEmpty()) {
			throw new PaymentNotFoundException(format("there aren't any payment from %s to %s.", from, to));
		}
		return payments;
	}

	public List<Payment> findByCreatedDateBetween(LocalDateTime from, LocalDateTime to) {
		List<Payment> payments = paymentRepository.findByCreatedDateBetween(from, to);
		if (payments.isEmpty()) {
			throw new PaymentNotFoundException(format("there aren't any payment from %s to %s.", from, to));
		}
		return payments;
	}

	public List<Payment> findAll() {
		return this.paymentRepository.findAll();
	}

	public Payment save(Payment payment) {
		return this.paymentRepository.save(payment);
	}

	public void deleteAll() {
		this.paymentRepository.deleteAll();

	}

}
