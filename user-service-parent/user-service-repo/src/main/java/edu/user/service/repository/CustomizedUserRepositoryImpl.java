package edu.user.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import edu.user.repository.models.UserEntity;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public List<UserEntity> findAllByTuid(List<Integer> tuids) {

		Criteria criteria = Criteria.where("tuid").in(tuids);
		return mongoOperations.find(Query.query(criteria), UserEntity.class);
	}
}
