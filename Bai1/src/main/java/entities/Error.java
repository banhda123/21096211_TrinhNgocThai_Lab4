package entities;

public class Error {
	private String type;
	private String message;
	
	public Error() {
		super();
	}

	public Error(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Error [type=" + type + ", message=" + message + "]";
	}
	
	
}
