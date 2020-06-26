package server.side.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Entity
public class Abonee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	private String emailorg;
	@NotBlank
	@Email
	private String emailvol;
	@NotBlank
	private String etat;

	public Abonee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailorg() {
		return emailorg;
	}

	public void setEmailorg(String emailorg) {
		this.emailorg = emailorg;
	}

	public String getEmailvol() {
		return emailvol;
	}

	public void setEmailvol(String emailvol) {
		this.emailvol = emailvol;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
