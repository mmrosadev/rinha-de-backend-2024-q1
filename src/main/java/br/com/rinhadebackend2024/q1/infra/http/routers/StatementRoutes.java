package br.com.rinhadebackend2024.q1.infra.http.routers;

import br.com.rinhadebackend2024.q1.infra.http.controller.statement.StatementGetController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes/{id}")
public class StatementRoutes {

    private final StatementGetController statementGetController;

    public StatementRoutes(StatementGetController statementGetController) {
        this.statementGetController = statementGetController;
    }

    @GetMapping("/extrato")
    public ResponseEntity<Object> getStatement(@PathVariable Long id) {
        return statementGetController.getStatement(id);
    }
}