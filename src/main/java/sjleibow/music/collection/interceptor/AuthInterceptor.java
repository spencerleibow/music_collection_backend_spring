package sjleibow.music.collection.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import sjleibow.music.collection.service.AuthorizationService;

public class AuthInterceptor implements HandlerInterceptor {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	private static final Logger logger = LogManager.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("Authorizing client: " + request.getRemoteAddr());
		authorizationService.authorizeClient(request);
		logger.info("Client authorized: " + request.getRemoteAddr());
		return true;
	}
}
