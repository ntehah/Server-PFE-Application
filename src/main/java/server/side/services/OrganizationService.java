package server.side.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Organization;
import server.side.payload.AjouterOrganizationRequest;
import server.side.payload.ProfileOrganizationResponse;
import server.side.repository.AboneeRepository;
import server.side.repository.EvenementRepository;
import server.side.repository.OrganizationRepository;

@Service

public class OrganizationService {

	private OrganizationRepository organizationRepository;
	private EvenementRepository evenementRepository;
	private AboneeRepository aboneeRepository;
	Logger logger = Logger.getLogger(VolunteerService.class.getName());

	@Autowired
	public OrganizationService(OrganizationRepository organizationRepository, EvenementRepository evenementRepository,
			AboneeRepository aboneeRepository) {
		this.organizationRepository = organizationRepository;
		this.aboneeRepository = aboneeRepository;
		this.evenementRepository = evenementRepository;
	}

	public List<Organization> getAllOrganization() {
		return organizationRepository.findAll();
	}

	public ProfileOrganizationResponse getOrganization(String email) {
		ProfileOrganizationResponse p = new ProfileOrganizationResponse();
		Organization o = organizationRepository.findByEmail(email);
		long nv = evenementRepository.countByOrganization(o);
		long nm = aboneeRepository.countByEmailorgAndEtat(o.getEmail(), "ACCEPTE");
		p.setDescription(o.getDescription());
		p.setName(o.getName());
		p.setEmail(o.getEmail());
		p.setPhoto(o.getPhoto());
		p.setId(o.getId());
		p.setNbEvents(nv);
		p.setNbMembre(nm);
		return p;
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
