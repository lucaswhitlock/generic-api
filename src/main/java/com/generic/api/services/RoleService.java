/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.services;

import com.generic.api.entities.Role;
import com.generic.api.exceptions.types.BusinessException;
import com.generic.api.repositories.RoleRepository;
import com.generic.api.resources.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 *
 * @author lucas
 */
@Service
public class RoleService extends AbstractService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void validateCreateOrUpdate(Role entity) {
        if (ObjectUtils.isEmpty(entity)) {
            throw new RuntimeException("There was an error tring to save the role provided!");
        }
        if (ObjectUtils.isEmpty(entity.getName())) {
            throw new BusinessException("The role must have a valid name!");
        }
    }

    @Override
    public JpaRepository getRepository() {
        return this.roleRepository;
    }

}
