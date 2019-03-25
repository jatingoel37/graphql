package edu.user.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.user.repository.models.relationships.HierarchicalApprovalApproveRelationshipEntity;
import edu.user.service.domain.models.UserCreationResponse;
import edu.user.service.repository.ApproverApproveeRelationRepository;

@Controller
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApproverApproveeRelationController {

	@Autowired
	private ApproverApproveeRelationRepository approverApproveeRelationRepository;

	@ResponseBody
	@RequestMapping(value = "/approver-approvee-relations", method = RequestMethod.POST)
	public UserCreationResponse createUser(@RequestBody HierarchicalApprovalApproveRelationshipEntity relation) {

		relation = approverApproveeRelationRepository.save(relation);
		return new UserCreationResponse(relation.getId());

	}

}
