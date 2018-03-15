package com.cdut.blog.article.config.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

/**
 * MongoDB登录端.
 * 
 * @author : Zilean
 * @date : 2018-03-12 11:47
 */
@Service
public class MongoClientConfig {

    @Autowired
    private MongoConfig mongoConfig;

    /**
     * 必须设置 primary ,否则以后将无法设置多源数据.
     * 
     * @return
     * @throws UnknownHostException
     */
    @Primary
    @Bean
    @Profile(value = "dev")
    public MongoDbFactory dbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(new MongoClientURI("mongodb://" + mongoConfig.getCdutUsername() + ":"
                + mongoConfig.getCdutPassword() + "@" + mongoConfig.getFirstHost() + ":" + mongoConfig.getPort() + "/"
                + mongoConfig.getCdutDatabase()));
    }

    @Primary
    @Bean
    @Profile(value = "dev")
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(dbFactory());
    }

    @Primary
    @Bean
    @Profile(value = { "test", "prod" })
    public MongoDbFactory mongo() throws Exception {

        MongoClientOptions option = MongoClientOptions.builder().connectTimeout(mongoConfig.getTimeout())
                .readPreference(ReadPreference.primaryPreferred()).build();

        List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        ServerAddress addr = new ServerAddress(mongoConfig.getFirstHost(), mongoConfig.getPort());
        ServerAddress addr2 = new ServerAddress(mongoConfig.getSecondHost(), mongoConfig.getPort());
        addresses.add(addr);
        addresses.add(addr2);
        MongoCredential mongoCredential = MongoCredential.createCredential(mongoConfig.getCdutUsername(),
                mongoConfig.getCdutDatabase(), mongoConfig.getCdutPassword().toCharArray());
        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
        credentialsList.add(mongoCredential);
        MongoClient client = new MongoClient(addresses, credentialsList, option);

        return new SimpleMongoDbFactory(client, mongoConfig.getCdutDatabase());
    }

    @Primary
    @Bean
    @Profile(value = { "test", "prod" })
    public MongoTemplate getmongoTemplate() throws Exception {
        return new MongoTemplate(mongo());
    }
}
