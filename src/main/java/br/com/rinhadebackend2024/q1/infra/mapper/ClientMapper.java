package br.com.rinhadebackend2024.q1.infra.mapper;

import br.com.rinhadebackend2024.q1.domain.client.entity.Client;
import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.ClientEntity;

public class ClientMapper {

    public static Client toDomain(ClientEntity clientEntity) {
        return new Client(
                clientEntity.getId(),
                clientEntity.getNome(),
                clientEntity.getLimite(),
                clientEntity.getSaldo()
        );
    }

    public static ClientEntity toEntity(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(client.getId());
        clientEntity.setNome(client.getNome());
        clientEntity.setLimite(client.getLimite());
        clientEntity.setSaldo(client.getSaldo());
        return clientEntity;
    }
}
