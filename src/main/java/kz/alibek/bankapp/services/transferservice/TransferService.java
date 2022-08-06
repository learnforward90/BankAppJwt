package kz.alibek.bankapp.services.transferservice;

import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    void transferFromOneToAnotherAccount(String clientId, String fromAccountId, String toAccountId, Double amount);
}
