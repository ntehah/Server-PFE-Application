package server.side.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Message;
@Repository
public interface ChatRepository extends JpaRepository<Message, Long> {
	List<Message> findBySenderAndReceiver(String sender,String To);
	List<Message> findByRoom(String room);

}