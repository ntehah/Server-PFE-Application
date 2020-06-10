package server.side.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import server.side.model.Organization;
import server.side.model.User;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	Organization findByEmail(String email);

}