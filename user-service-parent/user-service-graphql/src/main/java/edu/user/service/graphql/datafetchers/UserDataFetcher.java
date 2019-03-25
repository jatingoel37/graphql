package edu.user.service.graphql.datafetchers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.user.repository.models.UserEntity;
import edu.user.service.graphql.DataFetcherComponent;
import edu.user.service.graphql.UserServiceDataFetcher;
import graphql.schema.DataFetchingEnvironment;

@DataFetcherComponent
public class UserDataFetcher implements UserServiceDataFetcher<CompletableFuture<UserEntity>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApproversDataFetcher.class);

	@Override
	public CompletableFuture<UserEntity> get(DataFetchingEnvironment environment) throws Exception {

		LOGGER.info("************ UserDataFetcher thread name: {} ", Thread.currentThread().getName());
		DataLoader<Integer, UserEntity> userDataLoader = environment.getDataLoader("userDataLoader");
		Integer tuid = environment.getArgument("tuid");
		return userDataLoader.load(tuid);
	}

	@Override
	public List<String> getTypeNames() {
		return Arrays.asList("user");
	}

}
