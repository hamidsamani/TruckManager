package ir.idevco.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <p>
 * Account class is a main class for storing account amounts. every instance of this class will be a transaction. A
 * transaction can be {@link Type#WITHDRAW} or {@link Type#DEPOSIT} type. card should be initialized with amount and
 * further calculations will be base on that initial value.
 * <p>
 * calculation on {@link Account}s should be base on aggregation on mongoDB.
 * 
 * @author Hamid Samani
 *
 */
@SuppressWarnings("serial")
@Document
public class Account implements Serializable {

	public enum Type {
		WITHDRAW, DEPOSIT
	}

	/**
	 * Default mongoDB id, will be setted via underlying mongoDB persistence provider.
	 */
	@Id
	private String id;
	/**
	 * Type of account transaction.
	 */
	private Type type;
	/**
	 * The amount of transaction.
	 */
	private int amount;
	/**
	 * The DateTime transaction occurred.
	 */
	@CreatedDate
	private LocalDateTime createdDate;

	/**
	 * Default private constructor.
	 * 
	 */
	private Account() {
	}

	/**
	 * @see {@link AccountBuilder#build()}
	 * @param accountBuilder
	 */
	private Account(AccountBuilder accountBuilder) {
		this.type = accountBuilder.type;
		this.amount = accountBuilder.amount;
	}

	/**
	 * @param id
	 * @param type
	 * @param amount
	 */
	public Account(Type type, int amount) {
		this.type = type;
		this.amount = amount;
	}

	/**
	 * will be called by persistence provider.s
	 * 
	 * @param id
	 * @param type
	 * @param amount
	 * @param createdDate
	 */
	@PersistenceConstructor
	public Account(String id, Type type, int amount, LocalDateTime createdDate) {
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.createdDate = createdDate;
	}

	public static AccountBuilder create() {
		return new AccountBuilder();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	static class AccountBuilder {
		private Type type;
		private int amount;

		public AccountBuilder type(Type type) {
			this.type = type;
			return this;
		}

		public AccountBuilder amount(int amount) {
			this.amount = amount;
			return this;
		}

		public Account build() {
			return new Account(this);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [id=").append(id).append(", type=").append(type).append(", amount=").append(amount)
				.append(", createdDate=").append(createdDate).append("]");
		return builder.toString();
	}

}
