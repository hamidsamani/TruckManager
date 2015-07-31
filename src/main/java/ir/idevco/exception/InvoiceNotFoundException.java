package ir.idevco.exception;

@SuppressWarnings("serial")
public class InvoiceNotFoundException extends RuntimeException {

	public InvoiceNotFoundException() {
		super();
	}

	public InvoiceNotFoundException(String message) {
		super(message);
	}

}
