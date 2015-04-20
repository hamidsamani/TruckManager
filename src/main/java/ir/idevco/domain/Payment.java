package ir.idevco.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Hamid Samani
 *
 */
@SuppressWarnings("serial")
@Document
public class Payment implements Serializable {
	@Id
	private String id;
	@CreatedDate
	private LocalDateTime createdDate;

	private String title;
	private String description;

	private Person payer;
	private Person recipient;

	private int amount;

	/**
	 * 
	 */
	public Payment() {
	}

	public Payment(PaymentBuilder paymentBuilder) {
		this.title = paymentBuilder.title;
		this.description = paymentBuilder.description;
		this.payer = paymentBuilder.payer;
		this.recipient = paymentBuilder.recipient;
		this.amount = paymentBuilder.amount;
	}

	/**
	 * @param title
	 * @param description
	 * @param amount
	 * @param payer
	 * @param recipient
	 */
	public Payment(String title, String description) {
		this.title = title;
		this.description = description;
	}

	@PersistenceConstructor
	public Payment(String id, LocalDateTime createdDate, String title, String description, Person payer,
			Person recipient, int amount) {
		this.id = id;
		this.createdDate = createdDate;
		this.title = title;
		this.description = description;
		this.payer = payer;
		this.recipient = recipient;
		this.amount = amount;
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

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the payer
	 */
	public Person getPayer() {
		return payer;
	}

	/**
	 * @param payer the payer to set
	 */
	public void setPayer(Person payer) {
		this.payer = payer;
	}

	/**
	 * @return the recipient
	 */
	public Person getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(Person recipient) {
		this.recipient = recipient;
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

	public static PaymentBuilder create() {
		return new PaymentBuilder();
	}

	static class PaymentBuilder {
		private String title;
		private String description;

		private Person payer;
		private Person recipient;

		private int amount;

		public PaymentBuilder title(String title) {
			this.title = title;
			return this;
		}

		public PaymentBuilder description(String description) {
			this.description = description;
			return this;
		}

		public PaymentBuilder payer(Person payer) {
			this.payer = payer;
			return this;
		}

		public PaymentBuilder recipient(Person recipient) {
			this.recipient = recipient;
			return this;
		}

		public PaymentBuilder amount(int amount) {
			this.amount = amount;
			return this;
		}

		public Payment build() {
			return new Payment(this);
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [id=").append(id).append(", createdDate=").append(createdDate).append(", title=")
				.append(title).append(", description=").append(description).append(", payer=").append(payer)
				.append(", recipient=").append(recipient).append(", amount=").append(amount).append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
