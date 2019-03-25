package edu.user.repository.models.relationships;

public abstract class ApprovalApproveRelationshipEntity {

	private String id;
	private Integer companyId;
	private Integer approver;
	private Integer approve;
	private RelationshipType type;

	public Integer getApprover() {
		return approver;
	}

	public void setApprover(Integer approver) {
		this.approver = approver;
	}

	public Integer getApprove() {
		return approve;
	}

	public void setApprove(Integer approve) {
		this.approve = approve;
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}

	// ----------------------------------
	// Relationship type
	// ----------------------------------

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static enum RelationshipType {

		HIERARCHICAL, SECURITY
	}
}
