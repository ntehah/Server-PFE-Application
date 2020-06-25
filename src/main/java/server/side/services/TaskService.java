package server.side.services;

import java.io.IOException;
import java.sql.Date;
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
import server.side.model.Organization;
import server.side.model.Task;
import server.side.model.Volunteer;
import server.side.payload.AjouterVolunteerRequest;
import server.side.payload.ResponseListOfEvent;
import server.side.payload.ResponseListOfVolunteer;
import server.side.payload.TaskPayload;
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
	private EvenementRepository evenementRepository;

	private TaskRepository taskRepository;

	@Autowired
	public TaskService(VolunteerRepository volunteerRepository, VolunteerService volunteerService,
			EvenementService evenementService, TaskRepository taskRepository, EvenementRepository evenementRepository) {
		this.volunteerService = volunteerService;
		this.evenementService = evenementService;
		this.taskRepository = taskRepository;
		this.volunteerRepository = volunteerRepository;
		this.evenementRepository = evenementRepository;

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

	public List<TaskPayload> getAllTaskByOrg(String email) {
		List<TaskPayload> l = new ArrayList<TaskPayload>();
		List<Task> listtask = taskRepository.findByEmailorg(email);
		for (int i = 0; i < listtask.size(); i++) {
			TaskPayload tsk = new TaskPayload();
			Optional<Volunteer> v = volunteerRepository.findById(listtask.get(i).getIdVolunteer());
			if (v.isPresent()) {
				tsk.setNameVolunteer(v.get().getName());
				tsk.setPhotoVolunteer(v.get().getPhoto());
			}
			Optional<Evenement> eve = evenementRepository.findById(listtask.get(i).getIdEvent());
			if (eve.isPresent()) {
				tsk.setNameEvenement(eve.get().getTitre());
				tsk.setPhotoEvenement(eve.get().getPhoto());
			}
			tsk.setDate(listtask.get(i).getDate());
			tsk.setDescription(listtask.get(i).getDescription());
			tsk.setTitre(listtask.get(i).getTitre());
			tsk.setState(listtask.get(i).getState());
			tsk.setId(listtask.get(i).getId());

			l.add(tsk);
		}
		return l;
	}

	public void saveTask(Long idEvent, Long idVolunteer, String description, long dates, String state, String emailorg,
			String titre,long id) throws IOException {

		Task task = new Task();
		if(id !=0) {
			task.setId(id);
		}
		task.setIdEvent(idEvent);
		task.setIdVolunteer(idVolunteer);
		task.setState(state);
		task.setDate(new Date(dates));
		task.setEmailorg(emailorg);
		task.setTitre(titre);
		task.setDescription(description);
		taskRepository.save(task);

	}
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}
}