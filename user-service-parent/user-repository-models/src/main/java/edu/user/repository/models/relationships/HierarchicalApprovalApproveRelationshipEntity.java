package edu.user.repository.models.relationships;

public class HierarchicalApprovalApproveRelationshipEntity extends ApprovalApproveRelationshipEntity {

	private Integer level;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
