package edu.user.repository.models.relationships;

public class SubstituteApproverRelationshipEntity {

	private Integer companyId;
	private Integer userId;
	private Integer delegateApproverId;
	private String from;
	private String to;

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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
