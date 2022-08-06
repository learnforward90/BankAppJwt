package kz.alibek.bankapp.services.depositservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    ResponseEntity<String> deposit(String accountId, String clientId, Double amount);
}
