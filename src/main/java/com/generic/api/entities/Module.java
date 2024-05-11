/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.entities;

import com.generic.api.resources.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "modules")
public class Module extends AbstractEntity {

    @Column(name = "mod_name", nullable = false)
    private String name;

}
