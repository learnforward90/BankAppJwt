package kz.alibek.bankapp.repository;

import kz.alibek.bankapp.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}
