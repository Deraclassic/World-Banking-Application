package com.dera.World.Banking.repository;

import com.dera.World.Banking.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository <Transaction, String>{

}
