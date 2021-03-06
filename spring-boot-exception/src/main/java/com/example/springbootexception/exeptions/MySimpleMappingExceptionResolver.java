package com.example.springbootexception.exeptions;

import com.example.springbootexception.Eslam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySimpleMappingExceptionResolver {

//    @Bean
//    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
//        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//        Properties mapping = new Properties();
//        mapping.put("java.lang.ArithmeticException", "mathError"); //key=exception full name. value, view name
//        mapping.put("java.lang.NullPointerException", "nullPointerError");
//        resolver.setExceptionMappings(mapping);
//        return resolver;
//    }


    @Bean
    public MyHandlerExceptionResolver getSimpleMappingExceptionResolver() {
        return new MyHandlerExceptionResolver();
    }

    @Bean
    public Eslam getEslamUser() {
        return new Eslam();
    }

}
