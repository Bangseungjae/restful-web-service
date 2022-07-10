package com.example.restfulwebservice;

import com.example.restfulwebservice.post.PostRepository;
import com.example.restfulwebservice.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
@SpringBootApplication
//@Import(SwaggerConfig.class)
public class RestfulWebServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServiceApplication.class, args);
    }

    @Bean
    public TestInit testInit(UserRepository userRepository, PostRepository postRepository){
        return new TestInit(userRepository, postRepository);
    }

    @Bean
    public LocaleResolver localResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }
}
