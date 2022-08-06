package kz.alibek.bankapp.services.authservice;

import kz.alibek.bankapp.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserAuthenticateService {
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
}
