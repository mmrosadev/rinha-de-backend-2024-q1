package br.com.rinhadebackend2024.q1.infra.datasource.database.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
@Getter
@Setter
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    @Column(name = "valor", nullable = false)
    private Integer valor;

    @Column(name = "tipo", nullable = false)
    private char tipo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "realizada_em", nullable = false)
    private LocalDateTime realizadaEm;
}
