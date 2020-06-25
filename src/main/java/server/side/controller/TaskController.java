package server.side.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.side.model.Evenement;
import server.side.model.Task;
import server.side.payload.AjouterEvenementReguest;
import server.side.payload.OrganizationResponse;
import server.side.payload.ResponseListOfEvent;
import server.side.payload.ResponseListOfVolunteer;
import server.side.payload.TaskPayload;
import server.side.repository.TaskRepository;
import server.side.services.EvenementService;
import server.side.services.TaskService;

@CrossOrigin(origins = "&{app.urlclient}")
@RestController
@RequestMapping("/api/task")
public class TaskController {
	@Autowired
	TaskService taskService;

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getallev")
	public List<ResponseListOfEvent> getAllE(@Valid @RequestBody String email) {

		JSONObject e = new JSONObject(email);
		return taskService.getAllEvent(e.getString("email"));

	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getVolunteers")
	public List<ResponseListOfVolunteer> getAllV(@Valid @RequestBody String email) {
		JSONObject e = new JSONObject(email);
		return taskService.getAllVolunteer(e.getString("email"));

	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/addtask")
	public String AddTask(@Valid @RequestBody String task) throws JSONException, IOException {
		JSONObject e = new JSONObject(task);
		System.out.println(e.toString());
		taskService.saveTask(e.getLong("idEvent"), e.getLong("idVolunteer"), e.getString("description"),
				e.getLong("date"), e.getString("state"), e.getString("emailorg"), e.getString("titre"),
				e.getLong("id"));

		return "task est ajouter";

	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getalltasks")
	public List<TaskPayload> GetAllTasks(@Valid @RequestBody String email) throws JSONException, IOException {
		JSONObject e = new JSONObject(email);
		return taskService.getAllTaskByOrg(e.getString("email"));

	}
	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/deletetask")
	public void DeleteEvent(@Valid @RequestBody String id) {
		JSONObject e = new JSONObject(id);
		taskService.deleteTask(e.getLong("id"));
	}
}
