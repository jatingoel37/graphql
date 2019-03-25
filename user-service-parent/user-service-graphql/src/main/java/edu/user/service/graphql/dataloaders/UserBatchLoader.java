package edu.user.service.graphql.dataloaders;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

import org.dataloader.BatchLoader;

import edu.user.repository.models.UserEntity;
import edu.user.service.repository.UserRepository;

public class UserBatchLoader implements BatchLoader<Integer, UserEntity> {

	private final UserRepository userRepository;
	private final Executor executor;

	public UserBatchLoader(UserRepository userRepository, Executor executor) {
		this.userRepository = userRepository;
		this.executor = executor;
	}

	@Override
	public CompletionStage<List<UserEntity>> load(List<Integer> keys) {

		return CompletableFuture.supplyAsync(() -> {
			return userRepository.findAllByTuid(keys);
		}, executor);

	}

}
