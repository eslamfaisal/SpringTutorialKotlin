package com.example.consumingapis;

import com.example.consumingapis.entity.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ConsumingApisApplication {

    Logger logger = LoggerFactory.getLogger(ConsumingApisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingApisApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        System.out.println("eslamaaaaaaaaaaa");
        return args -> {

            Post post = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/1", Post.class);
            logger.info(post.toString());
//            System.out.println(post.toString());

        };
    }
}
