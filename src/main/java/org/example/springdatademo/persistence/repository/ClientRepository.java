package org.example.springdatademo.persistence.repository;

import java.util.Optional;
import org.example.springdatademo.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUsername(String username);

    Optional<Client> findByEmail(String email);
}
