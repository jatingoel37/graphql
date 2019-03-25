package edu.user.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.user.repository.models.relationships.ApprovalApproveRelationshipEntity;

public interface ApproverApproveeRelationRepository extends MongoRepository<ApprovalApproveRelationshipEntity, String> {

	List<ApprovalApproveRelationshipEntity> findByApprove(Integer approvee);
}
