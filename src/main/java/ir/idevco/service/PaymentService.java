package ir.idevco.service;

import ir.idevco.domain.Payment;
import ir.idevco.repository.PaymentRepository;

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

	public List<Payment> findAll() {
		return this.paymentRepository.findAll();
	}

	public Payment save(Payment payment) {
		return this.paymentRepository.save(payment);
	}

}
