package server.side.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Abonee;

@Repository
public interface AboneeRepository extends JpaRepository<Abonee, Long> {
	Optional<Abonee> findByEmailvolAndEmailorg(String emailvol, String emailorg);
	List<Abonee> findByEmailorg(String email);
    long countByEmailorgAndEtat(String emailorg,String etat);

}