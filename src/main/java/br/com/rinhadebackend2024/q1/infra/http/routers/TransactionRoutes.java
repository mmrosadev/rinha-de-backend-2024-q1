package br.com.rinhadebackend2024.q1.infra.http.routers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.rinhadebackend2024.q1.domain.transaction.entity.Transaction;
import br.com.rinhadebackend2024.q1.infra.http.controller.transaction.TransactionCreateController;

@RestController
@RequestMapping("/clientes/{id}")
public class TransactionRoutes {

    private final TransactionCreateController transactionCreateController;
    private static final Logger logger = LoggerFactory.getLogger(TransactionRoutes.class);

    public TransactionRoutes(TransactionCreateController transactionCreateController) {
        this.transactionCreateController = transactionCreateController;
    }

    @PostMapping("/transacoes")
    public ResponseEntity<Object> createTransaction(
            @PathVariable Long id,
            @RequestBody Transaction transaction) {

        return this.transactionCreateController.createTransaction(id, transaction);
    }
}
