package com.steelzack.b2b2java8.configuration;

import com.steelzack.b2b2java8.predicates.withchangeinpredicate.SomethingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by joao on 14-5-16.
 */
@Configuration
public class Application {

    @Bean
    public SomethingService somethingService(){
        return new SomethingService();
    }
}
