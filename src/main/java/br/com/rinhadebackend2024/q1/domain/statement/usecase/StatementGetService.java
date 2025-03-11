package br.com.rinhadebackend2024.q1.domain.statement.usecase;

import br.com.rinhadebackend2024.q1.domain.statement.entity.Statement;
import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.ClientEntity;
import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.TransactionEntity;
import br.com.rinhadebackend2024.q1.infra.dto.TransactionDTO;
import br.com.rinhadebackend2024.q1.infra.mapper.TransactionMapper;
import br.com.rinhadebackend2024.q1.infra.repository.clients.ClientRepository;
import br.com.rinhadebackend2024.q1.infra.repository.transactions.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StatementGetService {

    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;

    public StatementGetService(TransactionRepository transactionRepository, ClientRepository clientRepository){
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<Object> getStatement(int clientId) {

        Optional<ClientEntity> clientEntity = this.clientRepository.findById(clientId);

        if(clientEntity.isEmpty()){
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }

        int saldo = clientEntity.get().getSaldo();
        int limite = clientEntity.get().getLimite();

        List<TransactionEntity> transactionsEntity = this.transactionRepository.findByClienteIdOrderByRealizadaEmAsc(clientId);
        List<TransactionDTO> lastTransactions = transactionsEntity
                .stream()
                .map(TransactionMapper::toDTO)
                .toList();

        Statement statement = new Statement(saldo, limite, lastTransactions);
        return ResponseEntity.ok(statement);
    }
}
