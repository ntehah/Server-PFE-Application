package server.side.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.side.model.Jour;
import server.side.payload.AjouterVolunteerRequest;
import server.side.payload.VolunteerResponse;
import server.side.repository.UserRepository;
import server.side.services.VolunteerService;

@CrossOrigin(origins = "http://192.168.1.20:19001")
@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {
	@Autowired
	VolunteerService volunteerService;
	@CrossOrigin(origins = "http://192.168.1.20:19001")
	@PostMapping("/ajouter")
	public ResponseEntity<?> AjouterUser(@Valid @RequestBody AjouterVolunteerRequest ajouterVolunteerRequest) throws IOException {
		volunteerService.saveVolunteer(ajouterVolunteerRequest);
		return ResponseEntity.ok(new VolunteerResponse(true, "Volunteer Bien Ajouter"));
	}

}
