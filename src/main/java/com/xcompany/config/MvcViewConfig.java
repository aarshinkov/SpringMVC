package com.xcompany.config;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.xcompany.controllers")
public class MvcViewConfig {

    @Bean
    public SpringResourceTemplateResolver srtr() {
        SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
        srtr.setPrefix("/WEB-INF/pages/");
        srtr.setSuffix(".html");
        srtr.setTemplateMode("HTML");
        srtr.setCharacterEncoding("UTF-8");
        srtr.setCacheable(false);
        srtr.setOrder(1);
        return srtr;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        Set<ITemplateResolver> templateResolvers = new HashSet();
        templateResolvers.add(srtr());

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolvers(templateResolvers);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
}
