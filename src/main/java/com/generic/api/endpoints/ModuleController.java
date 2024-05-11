/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.endpoints;

import com.generic.api.entities.Module;
import com.generic.api.resources.AbstractCrudController;
import com.generic.api.resources.AbstractService;
import com.generic.api.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping(path = "/modules")
public class ModuleController extends AbstractCrudController<Module> {

    @Autowired
    private ModuleService moduleService;

    @Override
    public AbstractService getService() {
        return this.moduleService;
    }

}
