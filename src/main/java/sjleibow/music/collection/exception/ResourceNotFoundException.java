package sjleibow.music.collection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class ResourceNotFoundException extends ApiException {

	private String resource;
	private int id;
	
	public ResourceNotFoundException(String resource, int id) {
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
