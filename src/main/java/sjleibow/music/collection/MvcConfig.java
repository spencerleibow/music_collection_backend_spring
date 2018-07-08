package sjleibow.music.collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sjleibow.music.collection.interceptor.AuthInterceptor;
import sjleibow.music.collection.interceptor.RequestLoggingInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(reqLogInterceptor());
		registry.addInterceptor(authInterceptor());
	}
	
	@Bean
	public RequestLoggingInterceptor reqLogInterceptor() {
		return new RequestLoggingInterceptor();
	}
	
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
}
