package server.side.controller;

import java.io.IOException;
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

import server.side.model.Notification;
import server.side.model.Organization;
import server.side.payload.AjouterOrganizationRequest;
import server.side.payload.OrganizationResponse;
import server.side.payload.ProfileOrganizationResponse;
import server.side.repository.NotificationRepository;
import server.side.services.OrganizationService;

@CrossOrigin(origins = "&{app.urlclient}")
@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
	@Autowired
	OrganizationService organizationService;
	@Autowired
	NotificationRepository notificationRepository;

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/ajouter")
	public ResponseEntity<?> AjouterOrganization(
			@Valid @RequestBody AjouterOrganizationRequest ajouterOrganizationRequest) throws IOException {
		organizationService.saveOrganization(ajouterOrganizationRequest);
		return ResponseEntity.ok(new OrganizationResponse(true, "Organization Bien Ajouter"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getprofil")
	public ProfileOrganizationResponse GetOrganization(@Valid @RequestBody String email) throws IOException {
		JSONObject e = new JSONObject(email);
		return organizationService.getOrganization(e.getString("email"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@GetMapping("/getallorganization")
	public List<Organization> GetAllOrganization() throws IOException {
		return organizationService.getAllOrganization();
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getnotification")
	public List<Notification> GetAllNotification(@Valid @RequestBody String email) throws IOException {
		JSONObject e = new JSONObject(email);

		return notificationRepository.findByEmail(e.getString("email"));
	}
}