package server.side.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Volunteer;
import server.side.payload.AjouterVolunteerRequest;
import server.side.repository.ActivityRepository;
import server.side.repository.QualificationRepository;
import server.side.repository.VolunteerRepository;

@Service
public class VolunteerService {

	private ActivityRepository activityRepository;
	private VolunteerRepository volunteerRepository;
	private CalendrierService calendrierService;
	private QualificationService qualificationService;
	Logger logger = Logger.getLogger(VolunteerService.class.getName());

	@Autowired
	public VolunteerService(ActivityRepository activityRepository, VolunteerRepository volunteerRepository,
			CalendrierService calendrierService, QualificationService qualificationService) {
		this.activityRepository = activityRepository;
		this.volunteerRepository = volunteerRepository;
		this.calendrierService = calendrierService;
		this.qualificationService = qualificationService;

	}

	public List<Volunteer> getAllVolunteer() {
		return volunteerRepository.findAll();
	}

	public void saveVolunteer(AjouterVolunteerRequest v) throws IOException {

		Volunteer vol = new Volunteer();
		vol.setEmail(v.getEmail());
		vol.setAddress(v.getAdress());
		vol.setDate_naissance(v.getDateDeNaissance());
		vol.setPhoto(v.getPhoto());
		vol.setNumero(v.getNumero());

		JSONObject cal = new JSONObject(v.getCalendrier());
		JSONArray qual = new JSONArray(v.getQualification());

		volunteerRepository.save(vol);
		calendrierService.saveCalendrier(cal, v.getEmail());
		qualificationService.saveQualification(qual, v.getEmail());
	}

	public void deleteVolunteer(Long id) {
		volunteerRepository.deleteById(id);
	}

	public Optional<Volunteer> getVolunteerById(Long id) {
		return volunteerRepository.findById(id);
	}
}
