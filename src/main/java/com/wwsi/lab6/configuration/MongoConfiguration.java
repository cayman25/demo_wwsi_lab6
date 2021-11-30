//package com.wwsi.demo.configuration;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Configuration
//public class MongoConfiguration extends AbstractMongoClientConfiguration {
//
//    @Override
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString(System.getenv("MONGO_URI"));
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "db_wwsi";
//    }
//
//    @Override
//    public Collection getMappingBasePackages() {
//        return Collections.singleton("com.wwsi");
//    }
//}