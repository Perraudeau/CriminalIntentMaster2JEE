package project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // Enable Spring MVC
@ComponentScan(basePackages = "project.communication") // Enable component
														// scanning
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver jspViewResolver() { // Configure a JSP
															// view resolver
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true); // Expose beans as
															// request
															// attributes
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// Ask DispatcherServlet to forward requests for static resources to the
		// servlet
		// container’s default servlet and not to try to handle them itself
		configurer.enable();
	}
}
