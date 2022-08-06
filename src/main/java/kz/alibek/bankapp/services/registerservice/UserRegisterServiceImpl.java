package kz.alibek.bankapp.services.registerservice;

import kz.alibek.bankapp.models.ERole;
import kz.alibek.bankapp.models.Role;
import kz.alibek.bankapp.models.User;
import kz.alibek.bankapp.repository.RoleRepo;
import kz.alibek.bankapp.repository.UserRepo;
import kz.alibek.bankapp.request.SignUpRequest;
import kz.alibek.bankapp.requestoutput.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements UserRegisterService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> registerUser(SignUpRequest signUpRequest) {
        if (userRepo.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new Messages(String.format("This email(%s) registered", signUpRequest.getEmail())));
        }
        Set<Role> roles = new HashSet<>();
        if (signUpRequest.getRoles() == null) {
            roles.add(new Role(ERole.ROLE_USER));
        } else {
            signUpRequest
                    .getRoles()
                    .forEach(role ->{
                        switch (role) {
                            case "admin":
                                roles.add(roleRepo.findRoleByName(ERole.ROLE_ADMIN.name()));
                                break;
                            case "moderator":
                                roles.add(roleRepo.findRoleByName(ERole.ROLE_MODERATOR.name()));
                                break;
                            default:
                                roles.add(roleRepo.findRoleByName(ERole.ROLE_USER.name()));
                        }});
        }
        userRepo.save(User.builder()
                .email(signUpRequest.getEmail())
                .encodedPassword(passwordEncoder.encode(signUpRequest.getPassword()))
                .roles(roles)
                .build()
        );
        Messages messages = new Messages("Successfully registered");
        return ResponseEntity.status(HttpStatus.OK).body(messages);
    }
}
