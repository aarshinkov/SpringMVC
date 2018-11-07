package com.xcompany.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class LanguageConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("WEB-INF/resources/");
    }

//  @Bean
//  public SessionLocaleResolver localeResolver()
//  {
//    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//    Locale defaultLocale = new Locale("en");
//    localeResolver.setDefaultLocale(defaultLocale);
//    return localeResolver;
//  }
    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        Locale defaultLocale = new Locale("en");
        localeResolver.setDefaultLocale(defaultLocale);
        localeResolver.setCookieName("lang");
        localeResolver.setCookieMaxAge(Integer.MIN_VALUE); //с 3 часа назад
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
