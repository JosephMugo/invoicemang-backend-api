package com.invoicemang.invoicemangbackendapi.repository;

import com.invoicemang.invoicemangbackendapi.model.Role;
import com.invoicemang.invoicemangbackendapi.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
