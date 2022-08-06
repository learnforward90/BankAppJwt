package kz.alibek.bankapp.services.creationservice;

import kz.alibek.bankapp.bank.account.Account;
import kz.alibek.bankapp.repository.AccountRepo;
import kz.alibek.bankapp.bank.account.AccountType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCreationServiceImpl implements AccountCreationService {
    @Autowired
    AccountRepo accountRepo;
    @Override
    public void create(String accountId, String clientId, AccountType accountType) {
        try {
            Account account = Account.builder()
                                        .accountId(accountId)
                                        .clientId(clientId)
                                        .accountType(accountType)
                                        .isWithdrawAllowed(accountType.isWithdrawAllowed())
                                    .build();
            accountRepo.save(account);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
