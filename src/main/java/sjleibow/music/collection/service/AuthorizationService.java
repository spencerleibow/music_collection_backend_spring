package sjleibow.music.collection.service;

import javax.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface AuthorizationService {
	public void authorizeClient(HttpServletRequest request);
}
