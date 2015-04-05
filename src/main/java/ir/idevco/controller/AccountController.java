package ir.idevco.controller;

import java.util.List;

import ir.idevco.domain.Account;
import ir.idevco.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Hamid Samani
 *
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
	private AccountService accountService;

	/**
	 * @param accountService
	 */
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Account> save(@RequestBody Account account) {
		this.accountService.save(account);
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Account>> findAll() {
		return new ResponseEntity<List<Account>>(this.accountService.findAll(), HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<String> error(Throwable ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
