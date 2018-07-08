package sjleibow.music.collection.service.impl;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sjleibow.music.collection.exception.UnauthorizedClientException;
import sjleibow.music.collection.service.AuthorizationService;

@Service
public class IpWhitelistAuthorizationServiceImpl implements AuthorizationService {
	
	@Value("#{'${sjleibow.music.collection.authorized.clients}'.split(',')}")
	private Set<String> authClients;

	@Override
	public void authorizeClient(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		if (!authClients.contains(remoteAddr)) {
			throw new  UnauthorizedClientException(remoteAddr);
		}
	}

}
