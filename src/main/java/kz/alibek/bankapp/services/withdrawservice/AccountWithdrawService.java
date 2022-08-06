package kz.alibek.bankapp.services.withdrawservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {

    ResponseEntity<String> withdraw(String accountId, String clientId, Double amount) throws IllegalArgumentException;
}
