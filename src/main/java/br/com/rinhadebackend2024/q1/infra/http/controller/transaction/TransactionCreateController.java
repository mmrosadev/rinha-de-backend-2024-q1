package br.com.rinhadebackend2024.q1.infra.http.controller.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.rinhadebackend2024.q1.domain.transaction.entity.Transaction;
import br.com.rinhadebackend2024.q1.domain.transaction.usecase.TransactionCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionCreateController {

    private final TransactionCreateService transactionCreateService;
    private static final Logger logger = LoggerFactory.getLogger(TransactionCreateController.class);

    public TransactionCreateController(TransactionCreateService transactionCreateService) {
        this.transactionCreateService = transactionCreateService;
    }

    public ResponseEntity<Object> createTransaction(
            Long id,
            Transaction transaction
    ) {

        int clientId = Integer.parseInt(String.valueOf(id));
        if (clientId <= 0) {
            return ResponseEntity.unprocessableEntity().body("the value of id must be positive.");
        }

        if (transaction == null) {
            return ResponseEntity.unprocessableEntity().body("body can't be empty");
        }

        if (transaction.getValor() == null || transaction.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().body("the value of transaction must be positive.");
        }

        if (transaction.getTipo() != 'c' && transaction.getTipo() != 'd') {
            return ResponseEntity.unprocessableEntity().body("the type of transaction must be 'c' or 'd'.");
        }

        if (transaction.getDescricao().isEmpty() || transaction.getDescricao().length() > 10) {
            return ResponseEntity.unprocessableEntity().body("the size of description must be between 1 and 10 characters.");
        }

        return transactionCreateService.createTransaction(transaction, clientId);
    }
}
