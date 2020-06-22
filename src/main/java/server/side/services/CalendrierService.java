package server.side.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Jour;
import server.side.model.Volunteer;
import server.side.repository.JourRepository;
import server.side.repository.VolunteerRepository;

@Service

public class CalendrierService {
	private JourRepository jourRepository;
	private VolunteerRepository volunteerRepository;

	@Autowired
	public CalendrierService(JourRepository jourRepository,
			VolunteerRepository volunteerRepository) {
		this.jourRepository = jourRepository;
		this.volunteerRepository = volunteerRepository;

	}

	public void saveCalendrier(JSONObject cal, String email) throws IOException {

		Volunteer v = volunteerRepository.findByEmail(email);

		Jour lundi = new Jour();
		Jour mardi = new Jour();
		Jour mercredi = new Jour();
		Jour jeudi = new Jour();
		Jour vendredi = new Jour();
		Jour samedi = new Jour();
		Jour dimanche = new Jour();

		lundi.setJourname("lundi");
		lundi.setMatin(cal.getJSONObject("lundi").getBoolean("matin"));
		lundi.setMidi(cal.getJSONObject("lundi").getBoolean("apresmidi"));
		lundi.setSoir(cal.getJSONObject("lundi").getBoolean("soire"));

		mardi.setJourname("mardi");
		mardi.setMatin(cal.getJSONObject("mardi").getBoolean("matin"));
		mardi.setMidi(cal.getJSONObject("mardi").getBoolean("apresmidi"));
		mardi.setSoir(cal.getJSONObject("mardi").getBoolean("soire"));

		mercredi.setJourname("mercredi");
		mercredi.setMatin(cal.getJSONObject("mercredi").getBoolean("matin"));
		mercredi.setMidi(cal.getJSONObject("mercredi").getBoolean("apresmidi"));
		mercredi.setSoir(cal.getJSONObject("mercredi").getBoolean("soire"));

		jeudi.setJourname("jeudi");
		jeudi.setMatin(cal.getJSONObject("jeudi").getBoolean("matin"));
		jeudi.setMidi(cal.getJSONObject("jeudi").getBoolean("apresmidi"));
		jeudi.setSoir(cal.getJSONObject("jeudi").getBoolean("soire"));

		vendredi.setJourname("vendredi");
		vendredi.setMatin(cal.getJSONObject("vendredi").getBoolean("matin"));
		vendredi.setMidi(cal.getJSONObject("vendredi").getBoolean("apresmidi"));
		vendredi.setSoir(cal.getJSONObject("vendredi").getBoolean("soire"));

		samedi.setJourname("samedi");
		samedi.setMatin(cal.getJSONObject("samedi").getBoolean("matin"));
		samedi.setMidi(cal.getJSONObject("samedi").getBoolean("apresmidi"));
		samedi.setSoir(cal.getJSONObject("samedi").getBoolean("soire"));

		dimanche.setJourname("dimanche");
		dimanche.setMatin(cal.getJSONObject("dimanche").getBoolean("matin"));
		dimanche.setMidi(cal.getJSONObject("dimanche").getBoolean("apresmidi"));
		dimanche.setSoir(cal.getJSONObject("dimanche").getBoolean("soire"));
		jourRepository.save(lundi);
		jourRepository.save(mardi);
		jourRepository.save(mercredi);
		jourRepository.save(jeudi);
		jourRepository.save(vendredi);
		jourRepository.save(samedi);
		jourRepository.save(dimanche);

		Set<Jour> c = new HashSet<>();
		c.add(lundi);
		c.add(mardi);
		c.add(mercredi);
		c.add(jeudi);
		c.add(vendredi);
		c.add(samedi);
		c.add(dimanche);
		v.setCalendrier(c);
		volunteerRepository.save(v);
	}
}