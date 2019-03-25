package edu.user.service.graphql;

import java.util.List;

import graphql.schema.DataFetcher;

public interface UserServiceDataFetcher<T> extends DataFetcher<T> {

	List<String> getTypeNames();
}
