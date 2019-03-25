package edu.user.repository.models.relationships;

public class ArrangerArrangeRelationshipEntity {

	private Integer companyId;
	private Integer arranger;
	private Integer arrangee;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getArranger() {
		return arranger;
	}

	public void setArranger(Integer arranger) {
		this.arranger = arranger;
	}

	public Integer getArrangee() {
		return arrangee;
	}

	public void setArrangee(Integer arrangee) {
		this.arrangee = arrangee;
	}

}
