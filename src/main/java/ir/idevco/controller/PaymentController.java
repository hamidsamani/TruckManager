package ir.idevco.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import ir.idevco.domain.Payment;
import ir.idevco.service.PaymentService;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(method = POST, consumes = "application/json")
	public ResponseEntity<Payment> save(@RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paymentService.save(payment), HttpStatus.CREATED);
	}

	// @RequestMapping(method = GET)
	public ResponseEntity<List<Payment>> findAll() {
		return new ResponseEntity<List<Payment>>(paymentService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = GET)
	public ResponseEntity<List<Payment>> findAllBetweenDates(
			@RequestParam(required = false, value = "fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s") LocalDateTime fromDate,
			@RequestParam(required = false, value = "toDate") @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s") LocalDateTime toDate) {

		return new ResponseEntity<List<Payment>>(paymentService.findByDateBetween(fromDate, toDate), HttpStatus.OK);
	}
}
