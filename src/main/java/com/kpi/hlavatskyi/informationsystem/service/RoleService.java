package com.kpi.hlavatskyi.informationsystem.service;

import com.kpi.hlavatskyi.informationsystem.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
