package tt.com.tutorial.pcg.organizer.exceptionhandler;

import java.io.Serializable;

public class HandlerResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3738513853230415941L;
	protected String header;
	protected String message;

	protected HandlerResponse() {
	}

	public HandlerResponse(String header, String message) {
		this.header = header;
		this.message = message;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
