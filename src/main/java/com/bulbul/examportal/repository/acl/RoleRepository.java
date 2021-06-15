package com.bulbul.examportal.repository.acl;

import com.bulbul.examportal.entity.acl.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getRoleByRoleName(String roleName);
}
