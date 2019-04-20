package kz.hh.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
    public MongoClient mongoClient() {
        return new MongoClient("172.16.17.132", 27017);
    }

    protected String getDatabaseName() {
        return "hr";
    }
}
