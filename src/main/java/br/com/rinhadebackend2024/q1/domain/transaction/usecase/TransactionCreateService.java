package br.com.rinhadebackend2024.q1.domain.transaction.usecase;

import br.com.rinhadebackend2024.q1.domain.client.entity.Client;
import br.com.rinhadebackend2024.q1.domain.transaction.entity.Transaction;
import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.ClientEntity;
import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.TransactionEntity;
import br.com.rinhadebackend2024.q1.infra.mapper.ClientMapper;
import br.com.rinhadebackend2024.q1.infra.mapper.TransactionMapper;
import br.com.rinhadebackend2024.q1.infra.repository.clients.ClientRepository;
import br.com.rinhadebackend2024.q1.infra.repository.transactions.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

@Service
public class TransactionCreateService {

    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;

    private static final Logger logger = LoggerFactory.getLogger(TransactionCreateService.class);

    public TransactionCreateService(TransactionRepository transactionRepository, ClientRepository clientRepository){
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<Object> createTransaction(Transaction transaction, int clientId){
        try{

            transaction.setClientId(clientId);
            transaction.setRealizadaEm(Instant.now());

            Optional<ClientEntity> clientEntity = this.clientRepository.findById(clientId);

            if(clientEntity.isEmpty()){
                return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
            }

            Client client = ClientMapper.toDomain(clientEntity.orElseThrow(() ->
                    new IllegalArgumentException("Client entity is missing")));

            char transactionType = transaction.getTipo();
            int valor = transaction.getValor();

            if(transactionType == 'c'){
                client.increaseSaldo(valor);
            }else {
                if(client.getSaldo() - valor < -client.getLimite()){
                    return new ResponseEntity<>("There is no limit enough to credit", HttpStatus.UNPROCESSABLE_ENTITY);
                }
                client.decreaseSaldo(valor);
            }

            clientEntity.get().setSaldo(client.getSaldo());
            this.clientRepository.save(clientEntity.get());
            TransactionEntity transactionEntity = TransactionMapper.toEntity(transaction);
            this.transactionRepository.save(transactionEntity);

            Map<String, Integer> result = Map.of(
                    "limite", client.getLimite(),
                    "saldo", client.getSaldo()
            );

            logger.info("Transaction saved successfully");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Failed to save transaction.", e);
            return new ResponseEntity<>("Failed to save transaction. " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}