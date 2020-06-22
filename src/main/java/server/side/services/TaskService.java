package server.side.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Abonee;
import server.side.model.Evenement;
import server.side.model.Task;
import server.side.model.Volunteer;
import server.side.payload.AjouterVolunteerRequest;
import server.side.payload.ResponseListOfEvent;
import server.side.payload.ResponseListOfVolunteer;
import server.side.repository.AboneeRepository;
import server.side.repository.ActivityRepository;
import server.side.repository.EvenementRepository;
import server.side.repository.OrganizationRepository;
import server.side.repository.TaskRepository;
import server.side.repository.VolunteerRepository;

@Service
public class TaskService {

	private VolunteerService volunteerService;
	private VolunteerRepository volunteerRepository;

	private EvenementService evenementService;
	private TaskRepository taskRepository;

	@Autowired
	public TaskService(VolunteerRepository volunteerRepository, VolunteerService volunteerService,
			EvenementService evenementService, TaskRepository taskRepository) {
		this.volunteerService = volunteerService;
		this.evenementService = evenementService;
		this.taskRepository = taskRepository;
		this.volunteerRepository = volunteerRepository;

	}

	public List<Task> getAllVolunteer() {
		return taskRepository.findAll();
	}

	public List<ResponseListOfVolunteer> getAllVolunteer(String email) {
		List<ResponseListOfVolunteer> list = new ArrayList<ResponseListOfVolunteer>();
		List<Volunteer> LV = volunteerService.getAllVolunteerByOrg(email);
		for (int i = 0; i < LV.size(); i++) {
			ResponseListOfVolunteer v = new ResponseListOfVolunteer();
			v.setNameVolunteer(LV.get(i).getName());
			v.setIdVolunteer(LV.get(i).getId());

			list.add(v);

		}
		return list;
	}

	public List<ResponseListOfEvent> getAllEvent(String email) {
		List<ResponseListOfEvent> list = new ArrayList<ResponseListOfEvent>();
		List<Evenement> LE = evenementService.getAllByOrganization(email);
		for (int i = 0; i < LE.size(); i++) {
			ResponseListOfEvent e = new ResponseListOfEvent();
			e.setNameEvent(LE.get(i).getTitre());
			e.setIdEvent(LE.get(i).getId());

			list.add(e);
		}
		return list;
	}

	public List<Task> getAllTaskByVol(String email) {
		List<Task> l = new ArrayList<Task>();
		l = taskRepository.findByIdVolunteer(volunteerRepository.findByEmail(email).getId());
		return l;
	}

	public void saveVolunteer(Long idEvent, Long idVolunteer, String description, String dates, String state)
			throws IOException {

		Task task = new Task();

	}

}