package ir.idevco.repository;

import ir.idevco.domain.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {

	List<Invoice> findByTitleLike(String title);

	List<Invoice> findByItemsTitleLike(String title);

	List<Invoice> findByTitleAndItemsTitle(String title, String itemsTitle);
}
