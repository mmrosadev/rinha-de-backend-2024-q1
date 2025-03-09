package br.com.rinhadebackend2024.q1.infra.repository.transactions;

import br.com.rinhadebackend2024.q1.infra.datasource.database.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}
