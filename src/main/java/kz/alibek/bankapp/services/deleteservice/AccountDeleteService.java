package kz.alibek.bankapp.services.deleteservice;

import org.springframework.stereotype.Service;

@Service
public interface AccountDeleteService {
    void delete(String accountId, String clientId);
}
