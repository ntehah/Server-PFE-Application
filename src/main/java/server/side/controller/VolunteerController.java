package server.side.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.side.model.Abonee;
import server.side.model.Volunteer;
import server.side.payload.AbonnePayload;
import server.side.payload.AjouterVolunteerRequest;
import server.side.payload.VolunteerResponse;
import server.side.repository.AboneeRepository;
import server.side.services.VolunteerService;

@CrossOrigin(origins = "&{app.urlclient}")
@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {
	@Autowired
	VolunteerService volunteerService;
	@Autowired
	AboneeRepository aboneeRepository;

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/ajouter")
	public ResponseEntity<?> AjouterVolunteer(@Valid @RequestBody AjouterVolunteerRequest ajouterVolunteerRequest)
			throws IOException {
		volunteerService.saveVolunteer(ajouterVolunteerRequest);
		return ResponseEntity.ok(new VolunteerResponse(true, "Volunteer Bien Ajouter"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getprofil")
	public Volunteer GetVolunteer(@Valid @RequestBody String email) throws IOException {
		JSONObject e = new JSONObject(email);
		Volunteer vol = volunteerService.getVolunteer(e.getString("email"));
		return vol;
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getvolunters")
	public List<Volunteer> GetVolunteerByOrg(@Valid @RequestBody String email) throws IOException {
		JSONObject e = new JSONObject(email);
		return volunteerService.getAllVolunteerByOrg(e.getString("email"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/abonne")
	public boolean Abonne(@Valid @RequestBody AbonnePayload ab) throws IOException {
		JSONObject e = new JSONObject(ab);
		Abonee a = new Abonee();
		a.setEmailorg(e.getString("emailorg"));
		a.setEmailvol(e.getString("emailvol"));
		a.setEtat(e.getString("etat"));

		Abonee b = aboneeRepository.save(a);
		if (b == null)
			return false;

		return true;
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getabonne")
	public Abonee GetAbonne(@Valid @RequestBody String email) throws IOException {
		JSONObject e = new JSONObject(email);

		return aboneeRepository.findByEmailvol(e.getString("email"));

	}
}
