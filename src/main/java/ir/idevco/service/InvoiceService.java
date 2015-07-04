package ir.idevco.service;

import static org.springframework.util.StringUtils.*;
import ir.idevco.domain.Invoice;
import ir.idevco.exception.InvoiceNotFoundException;
import ir.idevco.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
	private InvoiceRepository invoiceRepository;

	@Autowired
	public InvoiceService(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	public List<Invoice> determineInvoiceReport(String id, String title, String detail) {
		List<Invoice> searchResult = new ArrayList<>();
		if (hasText(id)) {
			searchResult.add(invoiceRepository.findOne(id));
		} else if (hasText(title) && hasText(detail)) {
			searchResult.addAll(invoiceRepository.findByTitleAndItemsTitle(title, detail));
		} else if (hasText(title)) {
			searchResult.addAll(invoiceRepository.findByTitle(title));
		} else if (hasText(detail)) {
			searchResult.addAll(invoiceRepository.findByItemsTitle(detail));
		}
		if (searchResult.isEmpty()) {
			throw new InvoiceNotFoundException();
		}
		return searchResult;
	}

	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
}
