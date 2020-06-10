package server.side.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Jour;

@Repository
public interface JourRepository extends JpaRepository<Jour, Long> {
}