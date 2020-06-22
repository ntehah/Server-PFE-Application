package server.side.payload;

import javax.validation.constraints.NotBlank;

public class AbonnePayload {
	@NotBlank
	private String emailorg;
	@NotBlank
	private String emailvol;
	@NotBlank
	private String etat;
	
	public AbonnePayload() {
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
	public String isEtat() {
		return etat;
	}
	public void setEtat( String etat) {
		this.etat = etat;
	}
	
}
