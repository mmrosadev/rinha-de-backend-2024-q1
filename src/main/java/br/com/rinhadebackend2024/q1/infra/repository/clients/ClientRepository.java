package br.com.rinhadebackend2024.q1.infra.repository.clients;

import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
}
