package edu.user.service.repository;

import java.util.List;

import edu.user.repository.models.UserEntity;

public interface CustomizedUserRepository {

	/**
	 * This method has to make sure that if for any tuid user entity is missing,
	 * pass null there.
	 * 
	 * @param tuids
	 * @return
	 */
	List<UserEntity> findAllByTuid(List<Integer> tuids);

}
