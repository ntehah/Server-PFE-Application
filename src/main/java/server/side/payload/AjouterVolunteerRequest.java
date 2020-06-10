package server.side.payload;

import javax.validation.constraints.NotBlank;

public class AjouterVolunteerRequest {

	@NotBlank
	private String adress;
	@NotBlank
	private String calendrier;
	@NotBlank
	private String numero;
	@NotBlank
	private String email;
	@NotBlank
	private String dateDeNaissance;
	@NotBlank
	private String photo;
	@NotBlank
	private String qualification;

	public AjouterVolunteerRequest() {
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(String calendrier) {
		this.calendrier = calendrier;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "AjouterVolunteerRequest [adress=" + adress + ", calendrier=" + calendrier + ", numero=" + numero
				+ ", email=" + email + ", dateDeNaissance=" + dateDeNaissance + ", photo=" + photo + ", qualification="
				+ qualification + "]";
	}

	

}
