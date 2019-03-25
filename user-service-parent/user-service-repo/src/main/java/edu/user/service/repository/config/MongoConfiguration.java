package edu.user.service.repository.config;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(value = "edu.user.service", mongoTemplateRef = "mongoOperations")
public class MongoConfiguration {

	@Value("${mongo.server.list:http://localhost:27017}")
	private String hosts;

	@Value("${mongo.dbname:user-test}")
	private String databaseName;

//	@Value("${mongo.username}")
//	private String mongoDbUserName;
//
//	@Value("${mongo.password}")
//	private String mongoDbPassword;
	@Value("${mongo.connections-per-host:10}")
	private Integer connectionsPerHost;
	@Value("${mongo.max-wait-time:1000}")
	private Integer maxWaitTime;
	@Value("${mongo.threads-allowed-to-block-for-connection-multiplier:2}")
	private Integer threadsAllowedToBlockForConnectionMultiplier;
	@Value("${mongo.write-number:1}")
	private Integer writeNumber;
	@Value("${mongo.fsync:false}")
	private Boolean fsync;
	@Value("${mongo.waitTimeout:0}")
	private Integer wtimeout;

	@Bean
	@Primary
	public MongoOperations mongoOperations() throws IOException {
		return new MongoTemplate(mongoDbFactory(), mongoConverter(mongoDbFactory()));
	}

	@Bean
	public MongoRepositoryFactory mongoRepositoryFactory() throws IOException {
		return new MongoRepositoryFactory(mongoOperations());
	}

	@Bean
	@Primary
	public MongoConverter mongoConverter(MongoDbFactory mongoDbFactory) throws IOException {
		MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(
				new DefaultDbRefResolver(mongoDbFactory), new MongoMappingContext());
		return mappingMongoConverter;
	}

	@Bean
	@Primary
	public MongoDbFactory mongoDbFactory() throws IOException {
		return createMongoDbFactory(ReadPreference.primaryPreferred());
	}

	private MongoDbFactory createMongoDbFactory(ReadPreference readPreference) throws IOException {
		MongoClient mongoClient = new MongoClient(parseServerAddresses(), Arrays.asList(), mongoClientOptions());
		mongoClient.setReadPreference(readPreference);
		return new SimpleMongoDbFactory(mongoClient, databaseName);

	}

	private List<ServerAddress> parseServerAddresses() throws IOException {
		List<ServerAddress> mongoServers = new ArrayList<>();
		String[] splitHosts = StringUtils.split(hosts, ',');
		for (String splitHost : splitHosts) {
			URL url = new URL(splitHost);
			ServerAddress serverAddress = new ServerAddress(url.getHost(), url.getPort());
			mongoServers.add(serverAddress);
		}
		return mongoServers;
	}

	private MongoClientOptions mongoClientOptions() {
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		builder.connectionsPerHost(connectionsPerHost);
		builder.maxWaitTime(maxWaitTime);
		builder.threadsAllowedToBlockForConnectionMultiplier(threadsAllowedToBlockForConnectionMultiplier);
		builder.writeConcern(new WriteConcern(writeNumber, wtimeout, fsync));
		return builder.build();
	}

}
