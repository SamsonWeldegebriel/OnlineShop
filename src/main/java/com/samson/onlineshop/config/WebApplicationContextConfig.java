package com.samson.onlineshop.config;

import com.samson.onlineshop.domain.Product;
import com.samson.onlineshop.interceptor.ProcessingTimeLogInterceptor;
import com.samson.onlineshop.interceptor.PromoCodeInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import org.springframework.web.util.UrlPathHelper;

import java.util.ArrayList;
import java.util.Locale;


@Configuration
@EnableWebMvc
@ComponentScan("com.samson.onlineshop")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/resources/images/");
    }

    /*File Upload*/
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10240000);
        return resolver;
    }


    /*JSON View*/
    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        return jsonView;
    }

    /*XML View as follows*/
    @Bean
    public MarshallingView xmlView() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Product.class);
        MarshallingView xmlView = new MarshallingView(marshaller);
        return xmlView;
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        ArrayList<View> views = new ArrayList<View>();
        views.add(jsonView());
        views.add(xmlView());
        resolver.setDefaultViews(views);
        return resolver;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ProcessingTimeLogInterceptor());

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        registry.addInterceptor(localeChangeInterceptor);

        registry.addInterceptor(promoCodeInterceptor()).addPathPatterns("/**/market/products/specialOffer");

    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        /*CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);*/
        return resolver;
    }

    @Bean
    public HandlerInterceptor promoCodeInterceptor() {
        PromoCodeInterceptor promoCodeInterceptor = new PromoCodeInterceptor();
        promoCodeInterceptor.setPromoCode("offer");
        promoCodeInterceptor.setOfferRedirect("market/products");
        promoCodeInterceptor.setErrorRedirect("invalidPromoCode");
        return promoCodeInterceptor;
    }

}
