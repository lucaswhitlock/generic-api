/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.endpoints;

import com.generic.api.entities.Role;
import com.generic.api.resources.AbstractCrudController;
import com.generic.api.resources.AbstractService;
import com.generic.api.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping(path = "/roles")
public class RoleController extends AbstractCrudController<Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public AbstractService getService() {
        return this.roleService;
    }

}
