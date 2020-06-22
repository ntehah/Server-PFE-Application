package server.side.payload;


import javax.validation.constraints.NotBlank;

public class MessagePayload {
	@NotBlank
	private String sender;
	private String to;
	private String id_room;
	@NotBlank
	private String content;
	
	public MessagePayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getId_room() {
		return id_room;
	}
	public void setId_room(String id_room) {
		this.id_room = id_room;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
