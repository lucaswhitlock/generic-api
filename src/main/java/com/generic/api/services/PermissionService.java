/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.services;

import com.generic.api.entities.Permission;
import com.generic.api.exceptions.types.BusinessException;
import com.generic.api.repositories.PermissionRepository;
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
public class PermissionService extends AbstractService<Permission> {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public JpaRepository getRepository() {
        return this.permissionRepository;
    }

    @Override
    public void validateCreateOrUpdate(Permission entity) {
        if (ObjectUtils.isEmpty(entity)) {
            throw new RuntimeException("There was an error tring to save the permission provided!");
        }
        if (ObjectUtils.isEmpty(entity.getModule())) {
            throw new BusinessException("The permission must have a valid module!");
        }
        if (ObjectUtils.isEmpty(entity.getRole())) {
            throw new BusinessException("The permission must have a valid role!");
        }
    }

}
