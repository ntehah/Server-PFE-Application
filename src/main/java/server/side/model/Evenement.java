package server.side.model;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evenement{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titre;
	private Date date;
	private Time debut;
	private Time fin;
	@NotBlank
	private String city;
	@NotBlank
	private String adress;
	@Lob
	private String photo;
	@NotBlank
	private String description;
	@ManyToOne(fetch = FetchType.EAGER , optional = false)
	@JoinColumn(name = "organization_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Organization organization;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "volunteer_Evenement", joinColumns = @JoinColumn(name = "evenement_id"), inverseJoinColumns = @JoinColumn(name = "volunteer_id"))
	private Set<Volunteer> participents = new HashSet<>();

	public Evenement() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Time getDebut() {
		return debut;
	}

	public void setDebut(Time debut) {
		this.debut = debut;
	}

	public Time getFin() {
		return fin;
	}

	public void setFin(Time fin) {
		this.fin = fin;
	}

	public String getCity() {
		return city;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Set<Volunteer> getParticipents() {
		return participents;
	}

	public void setParticipents(Set<Volunteer> participents) {
		this.participents = participents;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", titre=" + titre + ", date=" + date + ", debut=" + debut + ", fin=" + fin
				+ ", city=" + city + ", adress=" + adress + ", description=" + description
				+ ", organization=" + organization + ", participents=" + participents + "]";
	}

}
