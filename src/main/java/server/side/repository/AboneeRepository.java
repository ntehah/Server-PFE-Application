package server.side.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Abonee;

@Repository
public interface AboneeRepository extends JpaRepository<Abonee, Long> {
	Abonee findByEmailvol(String email);

	List<Abonee> findByEmailorg(String email);
}