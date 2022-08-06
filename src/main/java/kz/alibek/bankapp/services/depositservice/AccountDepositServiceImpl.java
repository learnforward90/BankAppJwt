package kz.alibek.bankapp.services.depositservice;

import kz.alibek.bankapp.bank.account.Account;
import kz.alibek.bankapp.bank.transaction.Transaction;
import kz.alibek.bankapp.bank.transaction.TransactionType;
import kz.alibek.bankapp.repository.AccountRepo;
import kz.alibek.bankapp.repository.TransactionRepo;
import kz.alibek.bankapp.requestoutput.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;

    @Override
    public ResponseEntity<String> deposit(String accountId, String clientId, Double amount) {
        if (amount <= 0) {
            return ResponseEntity.badRequest().body(Messages.ACCOUNT_TRANSACTION_FAILED);
        }

        Account account = accountRepo.findAccountByAccountIdAndClientId(accountId, clientId);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Messages.ACCOUNT_NOT_FOUNDED);
        }

        account.setBalance(account.getBalance() + amount);
        accountRepo.save(account);

        Transaction transaction = Transaction.builder()
                                            .clientId(clientId)
                                            .accountId(accountId)
                                            .amount(amount)
                                            .transactionType(TransactionType.DEPOSIT)
                                            .date(LocalDate.now().toString())
                                            .isTransferred(true)
                                            .build();
        transactionRepo.save(transaction);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("deposit to %s %s $%.2f", accountId, Messages.ACCOUNT_TRANSACTION_OK, amount));
    }
}
