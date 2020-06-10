package server.side.payload;

import javax.validation.constraints.NotBlank;

public class AjouterOrganizationRequest {
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String description;
	@NotBlank
	private String photo;
	public AjouterOrganizationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
