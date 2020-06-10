package server.side.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}