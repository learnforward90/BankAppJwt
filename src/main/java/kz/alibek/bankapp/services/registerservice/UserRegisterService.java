package kz.alibek.bankapp.services.registerservice;

import kz.alibek.bankapp.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserRegisterService {
    ResponseEntity<?> registerUser(SignUpRequest signUpRequest);
}
