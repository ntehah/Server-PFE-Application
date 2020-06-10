package server.side.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Organization;
import server.side.payload.AjouterOrganizationRequest;
import server.side.repository.OrganizationRepository;

@Service

public class OrganizationService {

	private OrganizationRepository organizationRepository;
	Logger logger = Logger.getLogger(VolunteerService.class.getName());

	@Autowired
	public OrganizationService(OrganizationRepository organizationRepository) {
		this.organizationRepository = organizationRepository;

	}

	public List<Organization> getAllOrganization() {
		return organizationRepository.findAll();
	}

	public Organization getOrganization(String email) {
		return organizationRepository.findByEmail(email);
	}

	public void saveOrganization(AjouterOrganizationRequest v) throws IOException {

		Organization org = new Organization();
		org.setEmail(v.getEmail());
		org.setDescription(v.getDescription());
		org.setName(v.getName());

		org.setPhoto(v.getPhoto());
		organizationRepository.save(org);
	}

	public void deleteVolunteer(Long id) {
		organizationRepository.deleteById(id);
	}

	public Optional<Organization> getVolunteerById(Long id) {
		return organizationRepository.findById(id);
	}
}
