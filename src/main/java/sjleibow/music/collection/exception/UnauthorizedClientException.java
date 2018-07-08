package sjleibow.music.collection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
@SuppressWarnings("serial")
public class UnauthorizedClientException extends ApiException {
	
	private String clientAddress;

	public UnauthorizedClientException(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	@Override
	public String getMessage() {
		return String.format("Request from unauthorized client, remote address=%s", clientAddress);
	}
}
