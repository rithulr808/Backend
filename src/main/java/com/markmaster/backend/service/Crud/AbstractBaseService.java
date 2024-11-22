package com.markmaster.backend.service.Crud;

import com.markmaster.backend.models.AbstractBaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface AbstractBaseService<T extends AbstractBaseEntity, ID extends Serializable> {
    public abstract T save(T entity);

    public abstract List<T> findAll(); // you might want a generic Collection if u prefer

    public abstract T findById(ID entityId);

    public abstract void update(T entity);

    public abstract T updateById(T entity, ID entityId);

    public abstract void delete(T entity);

    public abstract void deleteById(ID entityId);
    // other methods u might need to be generic

}