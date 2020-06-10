package server.side.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Qualifacation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String qualifacation;

	public Qualifacation() {
	}

	public Qualifacation(String qualifacation) {
		this.qualifacation = qualifacation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQualifacation() {
		return qualifacation;
	}

	public void setQualifacation(String qualifacation) {
		this.qualifacation = qualifacation;
	}

}
