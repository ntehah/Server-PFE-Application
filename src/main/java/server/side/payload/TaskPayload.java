package server.side.payload;

import java.sql.Date;

import javax.persistence.Lob;

public class TaskPayload {

	private String nameVolunteer;
	private String nameEvenement;
	private String titre;

	private String description;
	private String state;

	private Date date;
	private long id;
	@Lob
	private String photoVolunteer;
	@Lob
	private String photoEvenement;

	public TaskPayload() {
		super();
	}

	public String getState() {
		return state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNameVolunteer() {
		return nameVolunteer;
	}

	public void setNameVolunteer(String nameVolunteer) {
		this.nameVolunteer = nameVolunteer;
	}

	public String getNameEvenement() {
		return nameEvenement;
	}

	public void setNameEvenement(String nameEvenement) {
		this.nameEvenement = nameEvenement;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public String getPhotoVolunteer() {
		return photoVolunteer;
	}

	public void setPhotoVolunteer(String photoVolunteer) {
		this.photoVolunteer = photoVolunteer;
	}

	public String getPhotoEvenement() {
		return photoEvenement;
	}

	public void setPhotoEvenement(String photoEvenement) {
		this.photoEvenement = photoEvenement;
	}

}
