package br.com.rinhadebackend2024.q1.domain.client.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Client {

    private Integer id;
    private String nome;
    private int limite;
    private int saldo;

    public Client(Integer id,  String nome, int limite, int saldo) {
        this.id = id;
        this.nome = nome;
        this.limite = limite;
        this.saldo = saldo;
    }

    public void increaseSaldo(int valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            throw new IllegalArgumentException("Value of credit should be positive");
        }
    }

    public void decreaseSaldo(int valor) {
        this.saldo -= valor;
    }
}