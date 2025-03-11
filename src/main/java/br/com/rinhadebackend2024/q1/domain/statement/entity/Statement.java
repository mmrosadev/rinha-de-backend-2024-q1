package br.com.rinhadebackend2024.q1.domain.statement.entity;

import br.com.rinhadebackend2024.q1.infra.dto.TransactionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString

@JsonPropertyOrder({"saldo", "limite", "data_extrato", "ultimas_transacoes"})
public class Statement {

    private int saldo;
    private int limite;
    @JsonProperty("data_extrato")
    private Instant dataExtrato;
    @JsonProperty("ultimas_transacoes")
    private List<TransactionDTO> ultimasTransacoes;

    public Statement(int saldo, int limite, List<TransactionDTO> ultimasTransacoes){
        this.saldo = saldo;
        this.limite = limite;
        this.dataExtrato = Instant.now();
        this.ultimasTransacoes = ultimasTransacoes;
    }
}
