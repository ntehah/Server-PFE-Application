package server.side.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.side.model.Organization;
import server.side.payload.AjouterOrganizationRequest;
import server.side.payload.OrganizationResponse;
import server.side.services.OrganizationService;

@CrossOrigin(origins = "&{app.urlclient}")
@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
	@Autowired
	OrganizationService organizationService;

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/ajouter")
	public ResponseEntity<?> AjouterOrganization(
			@Valid @RequestBody AjouterOrganizationRequest ajouterOrganizationRequest) throws IOException {
		organizationService.saveOrganization(ajouterOrganizationRequest);
		return ResponseEntity.ok(new OrganizationResponse(true, "Organization Bien Ajouter"));
	}

	@CrossOrigin(origins = "&{app.urlclient}")
	@PostMapping("/getprofil")
	public Organization GetOrganization(@Valid @RequestBody String email) throws IOException {
		JSONObject e = new JSONObject(email);
		return organizationService.getOrganization(e.getString("email"));
	}

}