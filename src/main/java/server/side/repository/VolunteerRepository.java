package server.side.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Volunteer;


@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
	Volunteer findByEmail(String email);

    List<Volunteer> findByIdIn(List<Long> userIds);

    Boolean existsByEmail(String email);
}