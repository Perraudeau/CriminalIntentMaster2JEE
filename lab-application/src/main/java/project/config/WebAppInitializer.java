package project.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" }; // Map DispatcherServlet to '/'
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class }; // 2 application contexts...
		// Expected to load other beans (middle-tier and data-tier)
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class }; // Specify configuration class
		// Expected to load beans containing web components
		// such as controllers, view resolvers, and handler mappings
	}
}
