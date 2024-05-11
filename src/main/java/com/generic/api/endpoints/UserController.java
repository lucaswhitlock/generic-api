/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.endpoints;

import com.generic.api.authentication.models.AuthenticationRequest;
import com.generic.api.entities.User;
import com.generic.api.resources.AbstractCrudController;
import com.generic.api.resources.AbstractService;
import com.generic.api.services.UserService;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucas
 */
@RestController
@RequestMapping(path = "/users")
public class UserController extends AbstractCrudController<User> {

    @Autowired
    private UserService userService;

    @Override
    public AbstractService getService() {
        return this.userService;
    }

    @PostMapping(path = "/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException {
        return ResponseEntity.ok(this.userService.authenticate(authenticationRequest));
    }

    @Override
    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody User entity) {
        this.getService().create(entity);

        int n = 10100;

        String binary = Integer.toBinaryString(n);
        int iterator = 0;

        while(binary.charAt(iterator) == '1') {
            
        }
        

    }

}
