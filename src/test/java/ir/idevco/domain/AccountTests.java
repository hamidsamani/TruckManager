package ir.idevco.domain;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import ir.idevco.domain.Account.Type;

import org.junit.Test;

public class AccountTests {
	private static final int AMOUNT = 1_000_000;

	@Test
	public void accountCalculatedCorrectly() {
		Account account = Account.create().type(Type.DEPOSIT).amount(AMOUNT).build();

		assertThat(Type.DEPOSIT, is(account.getType()));
		assertThat(AMOUNT, is(account.getAmount()));

		Account account2 = Account.create().type(Type.WITHDRAW).amount(AMOUNT).build();

		assertThat(Type.WITHDRAW, is(account2.getType()));
		assertThat(AMOUNT, is(account2.getAmount()));
	}
}
