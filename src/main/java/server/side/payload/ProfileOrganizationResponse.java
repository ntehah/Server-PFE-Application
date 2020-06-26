package server.side.payload;

import javax.persistence.Lob;


public class ProfileOrganizationResponse {
	private Long id;
	private String email;
	private String name;
	@Lob
	private String photo;
	
	private String description;
	private Long nbMembre;
	private Long nbEvents;
	public ProfileOrganizationResponse() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getNbMembre() {
		return nbMembre;
	}
	public void setNbMembre(Long nbMembre) {
		this.nbMembre = nbMembre;
	}
	public Long getNbEvents() {
		return nbEvents;
	}
	public void setNbEvents(Long nbEvents) {
		this.nbEvents = nbEvents;
	}
	

}
