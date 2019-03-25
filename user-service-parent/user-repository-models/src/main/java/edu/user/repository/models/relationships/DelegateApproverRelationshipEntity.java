package edu.user.repository.models.relationships;

public class DelegateApproverRelationshipEntity {

	private Integer companyId;
	private Integer userId;
	private Integer delegateApproverId;
	private Double delegationTimeInHours;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDelegateApproverId() {
		return delegateApproverId;
	}

	public void setDelegateApproverId(Integer delegateApproverId) {
		this.delegateApproverId = delegateApproverId;
	}

	public Double getDelegationTimeInHours() {
		return delegationTimeInHours;
	}

	public void setDelegationTimeInHours(Double delegationTimeInHours) {
		this.delegationTimeInHours = delegationTimeInHours;
	}

}
