package br.com.rinhadebackend2024.q1.infra.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.Instant;

@Getter
@Setter
@ToString
public class TransactionDTO {

    private Integer clientId;
    private Integer valor;
    private char tipo;
    private String descricao;
    private Instant realizadaEm;

    public TransactionDTO(Integer clientId, Integer valor, char tipo, String descricao, Instant realizadaEm) {
        this.clientId = clientId;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.realizadaEm = realizadaEm;
    }

    public TransactionDTO(){}
}
