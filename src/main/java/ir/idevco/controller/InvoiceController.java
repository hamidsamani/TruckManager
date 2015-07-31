package ir.idevco.controller;

import ir.idevco.domain.Invoice;
import ir.idevco.service.InvoiceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {
	private InvoiceService invoiceService;

	@Autowired
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Invoice> findByID(@PathVariable(value = "id") String id) {

		return new ResponseEntity<Invoice>(this.invoiceService.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Invoice>> invoiceSearch(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "detail", required = false) String detail) {

		List<Invoice> searchResult = this.invoiceService.determineInvoiceReport(id, title, detail);

		if (!searchResult.isEmpty()) {
			return new ResponseEntity<List<Invoice>>(searchResult, HttpStatus.OK);
		}
		return new ResponseEntity<List<Invoice>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Invoice save(@RequestBody Invoice invoice) {
		return invoiceService.save(invoice);
	}

}
