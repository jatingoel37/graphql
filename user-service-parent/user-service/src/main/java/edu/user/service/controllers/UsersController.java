package edu.user.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.user.repository.models.UserEntity;
import edu.user.service.domain.models.UserCreationResponse;
import edu.user.service.repository.UserRepository;

@Controller
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UsersController {

	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public UserCreationResponse createUser(@RequestBody UserEntity user) {

		user = userRepository.save(user);
		return new UserCreationResponse(user.getId(), user.getTuid());

	}

}
