package br.com.rinhadebackend2024.q1.infra.mapper;

import br.com.rinhadebackend2024.q1.domain.transaction.entity.Transaction;
import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.TransactionEntity;

public class TransactionMapper {

    public static TransactionEntity toEntity(Transaction transaction){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setClienteId(transaction.getClientId());
        transactionEntity.setTipo(transaction.getTipo());
        transactionEntity.setDescricao(transaction.getDescricao());
        transactionEntity.setValor(transaction.getValor());
        transactionEntity.setRealizadaEm(transaction.getRealizadaEm());
        return transactionEntity;
    }


//    public static TransactionEntity toDomain(Transaction transaction){
//        TransactionEntity transactionEntity = new TransactionEntity();
//        transactionEntity.setClienteId(transaction.getClientId());
//        transactionEntity.setTipo(transaction.getTipo());
//        transactionEntity.setDescricao(transaction.getDescricao());
//        transactionEntity.setValor(transaction.getValor());
//        transactionEntity.setRealizadaEm(transaction.getRealizadaEm());
//        return transactionEntity;
//    }
}
