/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.repositories;

import com.generic.api.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lucas
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
