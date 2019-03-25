package edu.user.service.graphql.configs;

import java.io.InputStreamReader;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.user.service.graphql.datafetchers.ApproversDataFetcher;
import edu.user.service.graphql.datafetchers.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Configuration
public class GQLConfig {

	@Autowired
	private UserDataFetcher userDataFetcher;

	@Autowired
	private ApproversDataFetcher approversDataFetcher;

	@Autowired
	@Qualifier("approversAsyncExecutor")
	private Executor approversAsyncExecutor;

	@Autowired
	@Qualifier("userAsyncExecutor")
	private Executor userAsyncExecutor;

	@Bean
	public TypeDefinitionRegistry typeDefinitionRegistry() {
		SchemaParser schemaParser = new SchemaParser();
		return schemaParser.parse(new InputStreamReader(GQLConfig.class.getResourceAsStream("/users.graphqls")));
	}

	@Bean
	public RuntimeWiring runtimeWiring() {

//		AsyncDataFetcher<UserEntity> asyncUserDataFetcher = AsyncDataFetcher.async(userDataFetcher, userAsyncExecutor);
//		AsyncDataFetcher<List<ApprovalApproveRelationshipEntity>> asyncApproversDataFetcher = AsyncDataFetcher
//				.async(approversDataFetcher, approversAsyncExecutor);

		return RuntimeWiring.newRuntimeWiring()//
				.type("Query", typeWiring -> typeWiring//
						.dataFetcher("user", userDataFetcher)//
						.dataFetcher("approvers", approversDataFetcher))
				.build();
	}

	@Bean
	public GraphQL graphQLEngine() {
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry(), runtimeWiring());
		return GraphQL.newGraphQL(graphQLSchema).build();
	}

}
