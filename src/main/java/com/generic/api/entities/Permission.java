/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.generic.api.resources.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "permissions")
public class Permission extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "prm_mod_id", nullable = false)
    private Module module;

    @ManyToOne
    @JoinColumn(name = "prm_rl_id", nullable = false)
    @JsonBackReference
    private Role role;

    @Column(name = "prm_create", nullable = false)
    private Boolean create;

    @Column(name = "prm_read", nullable = false)
    private Boolean read;

    @Column(name = "prm_update", nullable = false)
    private Boolean update;

    @Column(name = "prm_delete", nullable = false)
    private Boolean delete;

}
