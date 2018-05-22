package sjleibow.music.collection.exception;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class RecordNotFoundException extends ApiException {

	private String resource;
	private int id;
	
	public RecordNotFoundException(String resource, int id) {
		super(HttpStatus.NOT_FOUND);
		this.resource = resource;
		this.id = id;
	}

	public String getResource() {
		return resource;
	}

	public int getId() {
		return id;
	}

	@Override
	public String getMessage() {
		return String.format("Record not found, resource=%s, id=%d", resource, id);
	}
	
	
}
