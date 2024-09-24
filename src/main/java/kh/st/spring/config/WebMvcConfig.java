package kh.st.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import kh.st.spring.interceptor.LoginIntercepter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kh.st.spring") 
public class WebMvcConfig implements WebMvcConfigurer {


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    //인터셉터
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 인터셉터 추가 및 URL 패턴 설정
        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/member/login");  // /member/login 에서 할 일이 끝나면
    }
}