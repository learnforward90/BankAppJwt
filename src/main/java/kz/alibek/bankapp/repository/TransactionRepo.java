package kz.alibek.bankapp.repository;

import kz.alibek.bankapp.bank.transaction.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    List<Transaction> findTransactionsByAccountIdAndClientId(String accountId, String clientId);
    @Transactional
    void deleteTransactionsByAccountId(String accountId);
}
