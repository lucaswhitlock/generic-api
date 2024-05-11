/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.services;

import com.generic.api.authentication.models.AuthenticationRequest;
import com.generic.api.authentication.models.AuthenticationResponse;
import com.generic.api.authentication.utils.TokenUtils;
import com.generic.api.entities.User;
import com.generic.api.exceptions.types.BusinessException;
import com.generic.api.repositories.UserRepository;
import com.generic.api.resources.AbstractService;
import com.generic.api.resources.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 *
 * @author lucas
 */
@Service
public class UserService extends AbstractService<User> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PasswordUtils passwordUtils;

    @Override
    public void validateCreateOrUpdate(User entity) {
        if (ObjectUtils.isEmpty(entity)) {
            throw new RuntimeException("There was an error trying to save the user provided!");
        }
        if (ObjectUtils.isEmpty(entity.getName())) {
            throw new BusinessException("The user must have a valid name!");
        }
        if (ObjectUtils.isEmpty(entity.getEmail())) {
            throw new BusinessException("The user must have a valid email address!");
        }
        if (ObjectUtils.isEmpty(entity.getLogin())) {
            throw new BusinessException("The user must have a valid login name!");
        }
        if (ObjectUtils.isEmpty(entity.getPassword())) {
            throw new BusinessException("The user must have a valid password!");
        } else {
            entity.setPassword(passwordUtils.encode(entity.getPassword()));
        }
        if (ObjectUtils.isEmpty(entity.getRole())) {
            throw new BusinessException("The user must have a valid role!");
        }
    }

    @Override
    public JpaRepository getRepository() {
        return this.userRepository;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new AuthenticationResponse(tokenUtils.generateToken(authentication));
    }
}
