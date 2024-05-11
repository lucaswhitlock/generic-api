/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.services;

import com.generic.api.entities.Module;
import com.generic.api.exceptions.types.BusinessException;
import com.generic.api.repositories.ModuleRepository;
import com.generic.api.resources.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author lucas
 */
@Service
public class ModuleService extends AbstractService<Module> {

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public void validateCreateOrUpdate(Module entity) {
        if (ObjectUtils.isEmpty(entity)) {
            throw new RuntimeException("There was an error trying to save the module provided!");
        }
        if (ObjectUtils.isEmpty(entity.getName())) {
            throw new BusinessException("The module must have a valid name!");
        }
    }

    @Override
    public JpaRepository getRepository() {
        return this.moduleRepository;
    }


    @Async
    public void asyncMethodWithVoidReturnType() {
        try {
            System.out.println();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
