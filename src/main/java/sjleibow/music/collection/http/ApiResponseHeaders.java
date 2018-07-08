package sjleibow.music.collection.http;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ApiResponseHeaders extends HttpHeaders {

	private static final long serialVersionUID = 1L;

	public ApiResponseHeaders() {
		setAccessControlAllowOrigin("*");
	}
}
