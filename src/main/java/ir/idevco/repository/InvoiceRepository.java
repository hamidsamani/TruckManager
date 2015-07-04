package ir.idevco.repository;

import ir.idevco.domain.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {

	List<Invoice> findByTitle(String title);

	List<Invoice> findByItemsTitle(String title);

	List<Invoice> findByTitleAndItemsTitle(String title, String itemsTitle);
}
