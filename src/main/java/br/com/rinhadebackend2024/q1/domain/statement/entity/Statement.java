package br.com.rinhadebackend2024.q1.domain.statement.entity;

import br.com.rinhadebackend2024.q1.domain.transaction.entity.Transaction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
public class Statement {

    private int saldo;
    private int limite;
    private Instant dataExtrato;
    private List<Transaction> ultimasTransacoes;

    public Statement(int saldo, int limite, List<Transaction> ultimasTransacoes){
        this.saldo = saldo;
        this.limite = limite;
        this.dataExtrato = Instant.now();
        this.ultimasTransacoes = ultimasTransacoes;
    }
}
