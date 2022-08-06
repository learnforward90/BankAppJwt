package kz.alibek.bankapp.services.listingservice;

import kz.alibek.bankapp.bank.account.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountListingService {
    public Account getClientAccount(String accountId, String clientId);
    public Account getAccount(String accountId);

    Account getClientWithdrawAccount(String accountId, String clientId);
    List<Account> getClientAccounts(String clientId);

    List<Account> getClientAccountsByType();
}
