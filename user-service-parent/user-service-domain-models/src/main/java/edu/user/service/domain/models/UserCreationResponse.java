package edu.user.service.domain.models;

public class UserCreationResponse {

	private String id;
	private Integer tuid;

	public UserCreationResponse(String id, Integer tuid) {
		this.id = id;
		this.setTuid(tuid);
	}

	public UserCreationResponse(String id) {
		this.id = id;
	}

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

}
