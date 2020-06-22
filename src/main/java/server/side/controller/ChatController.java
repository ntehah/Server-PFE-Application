package server.side.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.side.model.Evenement;
import server.side.model.Message;
import server.side.payload.MessagePayload;
import server.side.repository.ChatRepository;
import server.side.services.ChatService;

@CrossOrigin(origins = "&{app.urlclient}")
@RestController
@RequestMapping("/api/message")
public class ChatController {
	@Autowired
	ChatService chatService;

	@PostMapping("/getall")
	public List<Message> getRoomChat(@Valid @RequestBody String room) {

		JSONObject e = new JSONObject(room);
		System.out.println(e.getString("email"));
		List<Message> list = chatService.getRoomChat(e.getString("room"));

		return list;
	}

	@PostMapping("/save")
	public void SaveChat(@Valid @RequestBody MessagePayload message) throws IOException {
		chatService.saveMessage(message);
	}
}
