package edu.user.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.user.repository.models.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String>, CustomizedUserRepository {

	UserEntity findByTuid(Integer tuid);

}
