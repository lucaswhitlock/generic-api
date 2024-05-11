/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.endpoints;

import com.generic.api.entities.Permission;
import com.generic.api.resources.AbstractCrudController;
import com.generic.api.resources.AbstractService;
import com.generic.api.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping(path = "/permissions")
public class PermissionController extends AbstractCrudController<Permission> {

    @Autowired
    private PermissionService permissionService;

    @Override
    public AbstractService getService() {
        return this.permissionService;
    }

}
