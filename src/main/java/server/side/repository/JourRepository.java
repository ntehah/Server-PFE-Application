package server.side.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Evenement;
import server.side.model.Jour;
import server.side.model.Organization;
import server.side.model.Volunteer;

@Repository
public interface JourRepository extends JpaRepository<Jour, Long> {

}