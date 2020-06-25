package server.side.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByIdVolunteer(Long idVolunteer);

	List<Task> findByIdEvent(Long Event);
	List<Task> findByEmailorg(String email);

}