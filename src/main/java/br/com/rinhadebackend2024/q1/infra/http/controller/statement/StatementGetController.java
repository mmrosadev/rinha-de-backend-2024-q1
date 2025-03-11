package br.com.rinhadebackend2024.q1.infra.http.controller.statement;

import br.com.rinhadebackend2024.q1.domain.statement.usecase.StatementGetService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class StatementGetController {

    private final StatementGetService statementGetService;

    public StatementGetController(StatementGetService statementGetService) {
        this.statementGetService = statementGetService;
    }

    public ResponseEntity<Object> getStatement(Long id) {

        int clientId = Integer.parseInt(String.valueOf(id));

        if (clientId <= 0) {
            return ResponseEntity.unprocessableEntity().body("the value of id must be positive.");
        }

        return statementGetService.getStatement(clientId);
    }
}
