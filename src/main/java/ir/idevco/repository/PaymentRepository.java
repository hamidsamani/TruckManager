package ir.idevco.repository;

import java.time.LocalDateTime;
import java.util.List;

import ir.idevco.domain.Payment;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {

	List<Payment> findByDateBetween(LocalDateTime from, LocalDateTime to);

	List<Payment> findByCreatedDateBetween(LocalDateTime from, LocalDateTime to);
}
