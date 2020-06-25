package server.side.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long idEvent;
	private Long idVolunteer;
	private String emailorg;
	private String titre;

	private String description;
	private Date date;

	private String state;
	public Task() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdEvent() {
		return idEvent;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	public Long getIdVolunteer() {
		return idVolunteer;
	}
	public String getEmailorg() {
		return emailorg;
	}
	public void setEmailorg(String emailorg) {
		this.emailorg = emailorg;
	}
	public void setIdVolunteer(Long idVolunteer) {
		this.idVolunteer = idVolunteer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
