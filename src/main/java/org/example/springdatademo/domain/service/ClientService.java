package org.example.springdatademo.domain.service;

import org.example.springdatademo.persistence.entity.Client;
import org.example.springdatademo.persistence.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository clientRepository;
    private static final Logger logger = LoggerFactory.getLogger(ClientRepository.class);

    public ClientService(ClientRepository userRepository) {
        this.clientRepository = userRepository;
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerClient(Client client) {
        logger.info("Реєстрація користувача: {}", client.getUsername());

        if (clientRepository.findByEmail(client.getEmail()).isPresent()) {
            throw new RuntimeException("Email вже використовується.");
        }

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.addRole("ROLE_USER");
        clientRepository.save(client);
        logger.info("Користувача успішно зареєстровано: {}", client.getUsername());
    }
}
