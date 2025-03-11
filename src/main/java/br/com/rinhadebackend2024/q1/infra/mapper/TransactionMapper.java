package br.com.rinhadebackend2024.q1.infra.mapper;

import br.com.rinhadebackend2024.q1.domain.transaction.entity.Transaction;
import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.TransactionEntity;
import br.com.rinhadebackend2024.q1.infra.dto.TransactionDTO;

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

    public static Transaction toDomain(TransactionEntity transactionEntity){
        Transaction transaction = new Transaction();
        transaction.setId(transactionEntity.getId());
        transaction.setClientId(transactionEntity.getClienteId());
        transaction.setTipo(transactionEntity.getTipo());
        transaction.setDescricao(transactionEntity.getDescricao());
        transaction.setValor(transactionEntity.getValor());
        transaction.setRealizadaEm(transactionEntity.getRealizadaEm());
        return transaction;
    }

    public static TransactionDTO toDTO(TransactionEntity transactionEntity){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setClientId(transactionEntity.getClienteId());
        transactionDTO.setTipo(transactionEntity.getTipo());
        transactionDTO.setDescricao(transactionEntity.getDescricao());
        transactionDTO.setValor(transactionEntity.getValor());
        transactionDTO.setRealizadaEm(transactionEntity.getRealizadaEm());
        return transactionDTO;
    }
}
