package server.side.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Jour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 15)
	private String journame;
	private Boolean matin;
	private Boolean midi;
	private Boolean soir;

	public Jour() {
	}

	public Jour(@NotBlank @Size(max = 15) String journame, Boolean matin, Boolean midi, Boolean soir) {
		this.journame = journame;
		this.matin = matin;
		this.midi = midi;
		this.soir = soir;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return journame;
	}

	public void setUsername(String username) {
		this.journame = username;
	}

	public Boolean getMatin() {
		return matin;
	}

	public void setMatin(Boolean matin) {
		this.matin = matin;
	}

	public Boolean getMidi() {
		return midi;
	}

	public void setMidi(Boolean midi) {
		this.midi = midi;
	}

	public Boolean getSoir() {
		return soir;
	}

	public void setSoir(Boolean soir) {
		this.soir = soir;
	}

}
