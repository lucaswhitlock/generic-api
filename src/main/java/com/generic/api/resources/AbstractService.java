/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.generic.api.resources;

import com.generic.api.exceptions.types.NotFoundException;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @param <T>
 * @author lucas
 */
@Service
public abstract class AbstractService<T extends AbstractEntity> {

    private static final NotFoundException DATA_NOT_FOUND = new NotFoundException("Data not found!");

    public abstract JpaRepository getRepository();

    public abstract void validateCreateOrUpdate(T entity);

    public void create(T entity) {
        this.validateCreateOrUpdate(entity);
        this.getRepository().save(entity);
    }

    public Page<T> read(Pageable pageable) {
        return this.getRepository().findAll(pageable);
    }

    public T readById(Long id) {
        Optional<T> record = this.getRepository().findById(id);
        if (record.isEmpty()) {
            throw DATA_NOT_FOUND;
        }
        return record.get();
    }

    public void update(Long id, T entity) {
        this.validateCreateOrUpdate(entity);
        Optional<T> data = this.getRepository().findById(id);
        if (data.isEmpty()) {
            throw DATA_NOT_FOUND;
        }
        this.getRepository().save(entity);
    }

    public void delete(Long id) {
        Optional<T> data = this.getRepository().findById(id);
        if (data.isEmpty()) {
            throw DATA_NOT_FOUND;
        }
        this.getRepository().deleteById(id);
    }
}
