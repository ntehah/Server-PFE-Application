package server.side.services;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Message;
import server.side.payload.MessagePayload;
import server.side.repository.ChatRepository;

@Service
public class ChatService {
	private ChatRepository chatRepository;
	Logger logger = Logger.getLogger(VolunteerService.class.getName());

	@Autowired
	public ChatService(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;

	}

	public List<Message> getConversation(String sender, String to) {
		return chatRepository.findBySenderAndReceiver(sender, to);
	}

	public List<Message> getRoomChat(String room) {
		return chatRepository.findByRoom(room);
	}

	public void saveMessage(MessagePayload m) throws IOException {

		Message msg = new Message();
		msg.setSender(m.getSender());
		msg.setTo(m.getTo());
		msg.setRoom(m.getId_room());
		msg.setContent(m.getContent());
		msg.setTime(new Time(System.currentTimeMillis()));
		chatRepository.save(msg);
	}

}
