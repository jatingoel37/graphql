package edu.user.service.controllers;

import java.util.concurrent.Executor;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.user.service.graphql.dataloaders.UserBatchLoader;
import edu.user.service.repository.UserRepository;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;

@Controller
@RequestMapping(value = "/v1/graphQuery", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GraphQLController {
	@Autowired
	private GraphQL graphQL;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	@Qualifier("userAsyncExecutor")
	private Executor userAsyncExecutor;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ExecutionResult createUser(@RequestBody String query) {

		ExecutionInput.Builder inputBuilder = ExecutionInput//
				.newExecutionInput()//
				.query(query)//
				.dataLoaderRegistry(getDataLoaderRegistry());
		return graphQL.execute(inputBuilder);

	}

	private DataLoaderRegistry getDataLoaderRegistry() {
		DataLoaderRegistry registry = new DataLoaderRegistry();
		registry.register("userDataLoader",
				DataLoader.newDataLoader(new UserBatchLoader(userRepository, userAsyncExecutor)));
		return registry;
	}
}
