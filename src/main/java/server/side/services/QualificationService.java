package server.side.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.side.model.Jour;
import server.side.model.Qualifacation;
import server.side.model.Volunteer;
import server.side.repository.QualificationRepository;
import server.side.repository.VolunteerRepository;

@Service
public class QualificationService {
	private QualificationRepository qualificationRepository;
	private VolunteerRepository volunteerRepository;

	@Autowired
	public QualificationService(QualificationRepository qualificationRepository,
			VolunteerRepository volunteerRepository) {
		this.qualificationRepository = qualificationRepository;
		this.volunteerRepository = volunteerRepository;

	}

	public void saveQualification(JSONArray qual, String email) throws IOException {

		Volunteer v = volunteerRepository.findByEmail(email);
		Set<Qualifacation> qualifications = new HashSet<>();
		qual.forEach(item -> {
			JSONObject obj = (JSONObject) item;
			Qualifacation q = new Qualifacation();
			if (!obj.getString("value").equals("")) {
				q.setQualifacation(obj.getString("value"));
				qualificationRepository.save(q);
				qualifications.add(q);
			}
		});
		v.setQualifacations(qualifications);
		volunteerRepository.save(v);
	}
}
