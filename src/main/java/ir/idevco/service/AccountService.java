package ir.idevco.service;

import java.util.List;

import ir.idevco.domain.Account;
import ir.idevco.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Hamid Samani
 *
 */
@Service
public class AccountService {
	private AccountRepository repository;

	/**
	 * @param repository
	 */
	@Autowired
	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	public Account save(Account account) {
		return this.repository.save(account);
	}

	public List<Account> findAll() {
		return this.repository.findAll();
	}

}
