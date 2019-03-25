package edu.user.repository.models;

public class UserEntity {

	private String id;
	private Integer tuid;
	private Integer companyId;
	private String firstName;
	private String middleName;
	private String lastName;
	private DesignationEntity designation;
	private GenderEntity gender;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTuid() {
		return tuid;
	}

	public void setTuid(Integer tuid) {
		this.tuid = tuid;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public DesignationEntity getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationEntity designation) {
		this.designation = designation;
	}

	public GenderEntity getGender() {
		return gender;
	}

	public void setGender(GenderEntity gender) {
		this.gender = gender;
	}

}
