package server.side.payload;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

public class AjouterEvenementReguest {
	@NotBlank
	private String titre;
	
	private long date;
	private long debut;
	private long fin;
	@NotBlank
	private String city;
	@NotBlank
	private String adress;
	@Lob
	private String photo;
	@NotBlank
	private String description;
	@NotBlank
	private String email;
	private long id;

	public AjouterEvenementReguest() {
	}

	public String getTitre() {
		return titre;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public long getDebut() {
		return debut;
	}

	public void setDebut(long debut) {
		this.debut = debut;
	}

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		this.fin = fin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AjouterEvenementReguest [titre=" + titre + ", date=" + date + ", debut=" + debut + ", fin=" + fin
				+ ", city=" + city + ", adress=" + adress + ", photo=" + photo + ", description=" + description
				+ ", email=" + email + "]";
	}

}
