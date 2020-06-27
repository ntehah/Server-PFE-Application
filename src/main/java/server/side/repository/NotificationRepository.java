package server.side.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Notification;



@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByEmail(String email);
}