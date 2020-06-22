package server.side.services;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Evenement;
import server.side.model.Organization;
import server.side.payload.AjouterEvenementReguest;
import server.side.repository.EvenementRepository;
import server.side.repository.OrganizationRepository;

@Service

public class EvenementService {

	private OrganizationRepository organizationRepository;
	private EvenementRepository evenementRepository;

	Logger logger = Logger.getLogger(VolunteerService.class.getName());

	@Autowired
	public EvenementService(OrganizationRepository organizationRepository, EvenementRepository evenementRepository) {
		this.organizationRepository = organizationRepository;
		this.evenementRepository = evenementRepository;
	}

	public List<Evenement> getAllByOrganization(String Email) {
		return evenementRepository.findByOrganizationOrderByDateAsc(organizationRepository.findByEmail(Email));
	}

	public List<Evenement> getAll() {
		return evenementRepository.findAll();
	}

	public void saveEvenement(AjouterEvenementReguest e) throws IOException, ParseException {
		Organization or = organizationRepository.findByEmail(e.getEmail());
		Date date = new Date(e.getDate());
		Time debut = new Time(e.getDebut());
		Time fin = new Time(e.getDebut());
		System.out.println(or.toString());
		
		Evenement eve = new Evenement();
		if(e.getId()!=0) {
			eve.setId(e.getId());
		}
		eve.setTitre(e.getTitre());

		eve.setDate(date);

		eve.setDebut(debut);
		eve.setFin(fin);

		eve.setAdress(e.getAdress());
		eve.setCity(e.getCity());
		eve.setDescription(e.getDescription());
		eve.setOrganization(or);
		eve.setPhoto(e.getPhoto());
		evenementRepository.save(eve);

	}

	public void deleteEvent(Long id) {
		evenementRepository.deleteById(id);
	}

}
