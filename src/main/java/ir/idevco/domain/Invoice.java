package ir.idevco.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Invoice {

	@Id
	private String id;

	private LocalDateTime date;

	private String title;

	private String tell;

	private String address;

	private int milage;

	private List<Item> items;

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
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
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
	 * @return the tell
	 */
	public String getTell() {
		return tell;
	}

	/**
	 * @param tell the tell to set
	 */
	public void setTell(String tell) {
		this.tell = tell;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the milage
	 */
	public int getMilage() {
		return milage;
	}

	/**
	 * @param milage the milage to set
	 */
	public void setMilage(int milage) {
		this.milage = milage;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/**
	 * 
	 */
	public Invoice() {
	}

	/**
	 * @param id
	 * @param date
	 * @param milage
	 * @param items
	 */
	public Invoice(String id, LocalDateTime date, int milage, List<Item> items) {
		this.id = id;
		this.date = date;
		this.milage = milage;
		this.items = items;
	}

	/**
	 * @param date
	 * @param milage
	 * @param items
	 */
	public Invoice(LocalDateTime date, int milage, List<Item> items) {
		this.date = date;
		this.milage = milage;
		this.items = items;
	}

	public static class Item {
		private String id;
		private String title;
		private int quantity;
		private int price;

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
		 * @return the quantity
		 */
		public int getQuantity() {
			return quantity;
		}

		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		/**
		 * @return the price
		 */
		public int getPrice() {
			return price;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(int price) {
			this.price = price;
		}

		/**
		 * 
		 */
		public Item() {
		}

		/**
		 * @param id
		 * @param title
		 * @param quantity
		 * @param price
		 */
		public Item(String title, int quantity, int price) {
			this.title = title;
			this.quantity = quantity;
			this.price = price;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Item [id=").append(id).append(", title=").append(title).append(", quantity=").append(quantity)
					.append(", price=").append(price).append("]");
			return builder.toString();
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice [id=").append(id).append(", date=").append(date).append(", title=").append(title)
				.append(", tell=").append(tell).append(", address=").append(address).append(", milage=").append(milage)
				.append(", items=").append(items).append("]");
		return builder.toString();
	}

}
