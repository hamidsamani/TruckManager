package ir.idevco.controller;

import java.util.List;

import ir.idevco.domain.Payment;
import ir.idevco.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	private PaymentService paymentService;

	/**
	 * @param paymentService
	 */
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Payment> save(@RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paymentService.save(payment), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Payment>> findAll() {
		return new ResponseEntity<List<Payment>>(paymentService.findAll(), HttpStatus.OK);
	}

}
