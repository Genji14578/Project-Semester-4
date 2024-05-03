package com.example.demo.configurations;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemplateConfiguration implements WebMvcConfigurer {
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles_home.xml", // Bat dau tu webapp
				"/WEB-INF/tiles/tiles.xml", "/WEB-INF/tiles/tiles_aboutus.xml", "/WEB-INF/tiles/tiles_cart.xml",
				"/WEB-INF/tiles/tiles_contactus.xml", "/WEB-INF/tiles/tiles_products_single.xml",
				"/WEB-INF/tiles/tiles_admin.xml", "/WEB-INF/tiles/tiles_super_admin.xml",
				"/WEB-INF/tiles/tiles_products.xml"

		});
		return configurer;
	}
}
