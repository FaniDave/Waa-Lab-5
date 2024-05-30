package com.Lab_1.demo.Configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelWrapperConfig {

       @Bean
       public ModelMapper modelWrapper() {
           return new ModelMapper();
       }
}
