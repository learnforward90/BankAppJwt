package kz.alibek.bankapp.services.listingtransactions;

import kz.alibek.bankapp.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionListingService {
    public ResponseEntity<List<TransactionDto>> getTransactionsByAccountIdAndClientId(String accountId, String clientId);
}
