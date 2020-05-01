package com.example.demo;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class Aplication {

    public static void main(String[] args) {
        SpringApplication.run(Aplication.class, args);
    }

    @Bean
    public ErrorViewResolver error404() {
        return new ErrorViewResolver() {
            @Override
            public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status,
                    Map<String, Object> model) {
                if (status != HttpStatus.NOT_FOUND) {
                    return null;
                }
                ModelAndView modelAndView = new ModelAndView("/index.html");
                modelAndView.setStatus(HttpStatus.OK);
                return modelAndView;
            }
        };
    }

}
