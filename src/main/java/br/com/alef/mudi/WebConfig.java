package br.com.alef.mudi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.alef.mudi.inteceptor.InterceptadorDeAcessos;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport{
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InterceptadorDeAcessos()).addPathPatterns("/**");
	}

}
