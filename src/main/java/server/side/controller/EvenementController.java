package server.side.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

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
import server.side.payload.AjouterEvenementReguest;
import server.side.payload.OrganizationResponse;
import server.side.services.EvenementService;

@CrossOrigin(origins = "&{app.urlclient}")
@RestController
@RequestMapping("/api/evenement")
public class EvenementController {
	@Autowired
	EvenementService evenementService;

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/ajouter")
	public ResponseEntity<?> AjouterUser(@Valid @RequestBody AjouterEvenementReguest ajouterEvenementReguest)
			throws IOException, ParseException {

		evenementService.saveEvenement(ajouterEvenementReguest);
		return ResponseEntity.ok(new OrganizationResponse(true, "Evenement Bien Ajouter"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getall")
	public List<Evenement> getAllEvenementByOrganization(@Valid @RequestBody String email) {
		JSONObject e = new JSONObject(email);
		return evenementService.getAllByOrganization(e.getString("email"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/deleteevent")
	public void DeleteEvent(@Valid @RequestBody String id) {
		JSONObject e = new JSONObject(id);
		evenementService.deleteEvent(e.getLong("id"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@GetMapping("/getallevent")
	public List<Evenement> getAllEvenement() {
		return  evenementService.getAll();
	}
}
