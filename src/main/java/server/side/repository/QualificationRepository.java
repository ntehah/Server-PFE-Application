package server.side.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Qualifacation;


@Repository
public interface QualificationRepository extends JpaRepository<Qualifacation, Long> {
}