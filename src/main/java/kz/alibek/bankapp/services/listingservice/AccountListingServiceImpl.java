package kz.alibek.bankapp.services.listingservice;

import kz.alibek.bankapp.repository.AccountRepo;
import kz.alibek.bankapp.bank.account.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {
    private AccountRepo accountRepo;

    public AccountListingServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> getClientAccounts(String clientId) {
        return accountRepo.findAccountsByClientId(clientId);
    }

    @Override
    public Account getClientWithdrawAccount(String accountId, String clientId) {
        Account account = accountRepo.findAccountByAccountIdAndClientId(accountId, clientId);
        if (account.getIsWithdrawAllowed()) return account;
        return null;
    }

    @Override
    public Account getClientAccount(String accountId, String clientId) {
        return accountRepo.findAccountByAccountIdAndClientId(accountId, clientId);
    }

    @Override
    public Account getAccount(String accountId) {
        return accountRepo.findAccountByAccountId(accountId);
    }

    @Override
    public List<Account> getClientAccountsByType() {
        return null;
    }
}
