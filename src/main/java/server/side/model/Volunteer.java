package server.side.model;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
public class Volunteer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NaturalId
	@NotBlank
	@Size(max = 40)
	@Email
	private String email;
	@NotBlank
	@Size(max = 15)
	private String numero;
	@NotBlank
	@Size(max = 15)
	private String address;
	@NotBlank
	@Size(max = 15)
	private String date_naissance;
	@Lob
	private String photo;
//	ALTER TABLE pfe.volunteer
//	MODIFY photo MEDIUMBLOB;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "volunteer_Activite", joinColumns = @JoinColumn(name = "volunteer_id"), inverseJoinColumns = @JoinColumn(name = "Activite_id"))
	private Set<Activity> activites = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "volunteer_qualifacations", joinColumns = @JoinColumn(name = "volunteer_id"), inverseJoinColumns = @JoinColumn(name = "qualifacation_id"))
	private Set<Qualifacation> qualifacations = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "volunteer_calendrier", joinColumns = @JoinColumn(name = "volunteer_id"), inverseJoinColumns = @JoinColumn(name = "jour_id"))
	private Set<Jour> calendrier = new HashSet<>();

	public Volunteer() {
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Activity> getActivites() {
		return activites;
	}

	public void setActivites(Set<Activity> activites) {
		this.activites = activites;
	}

	public Set<Qualifacation> getQualifacations() {
		return qualifacations;
	}

	public void setQualifacations(Set<Qualifacation> qualifacations) {
		this.qualifacations = qualifacations;
	}

	public Set<Jour> getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Set<Jour> calendrier) {
		this.calendrier = calendrier;
	}

}
