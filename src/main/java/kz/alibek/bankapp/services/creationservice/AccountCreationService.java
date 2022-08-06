package kz.alibek.bankapp.services.creationservice;

import kz.alibek.bankapp.bank.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface AccountCreationService {
    public void create(String accountId, String clientId, AccountType accountType);
}