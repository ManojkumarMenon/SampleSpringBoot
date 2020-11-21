package com.manoj.practice.SampleSpringBoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class ApplicationConfiguration {

    @Value("${monog.db.name}")
    private String mongoDbName;

    @Value("${monog.host.name}")
    private String mongoHostName;

    @Value("${monog.port.no}")
    private int mongoPortNo;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(mongoClient(), mongoDbName);
    }

    @Bean
    public MongoClient mongoClient() {
        MongoClient client = new MongoClient(mongoHostName, mongoPortNo);
        return client;
    }

    @Bean
    public MongoOperations mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }

}
