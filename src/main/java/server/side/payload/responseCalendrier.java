package server.side.payload;

public class responseCalendrier {
	private String journame;
	private boolean matin;
	private boolean midi;
	private boolean soir;
	
	public responseCalendrier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getJourname() {
		return journame;
	}
	public void setJourname(String journame) {
		this.journame = journame;
	}
	public boolean isMatin() {
		return matin;
	}
	public void setMatin(boolean matin) {
		this.matin = matin;
	}
	public boolean isMidi() {
		return midi;
	}
	public void setMidi(boolean midi) {
		this.midi = midi;
	}
	public boolean isSoir() {
		return soir;
	}
	public void setSoir(boolean soir) {
		this.soir = soir;
	}


}
