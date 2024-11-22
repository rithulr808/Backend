package com.markmaster.backend.service.Crud;

import com.markmaster.backend.models.AbstractBaseEntity;
import com.markmaster.backend.repository.AbstractBaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class AbstractBaseRepositoryImpl<T extends AbstractBaseEntity, ID extends Serializable>
        implements AbstractBaseService<T, ID> {
    private final AbstractBaseRepository<T, ID> abstractBaseRepository;

    public AbstractBaseRepositoryImpl(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    @Override
    public T save(T entity) {
        return (T) abstractBaseRepository.save(entity);
    }

    @Override
    public List<T> findAll() {
        return abstractBaseRepository.findAll();
    }

    @Override
    public T findById(ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        return (T) optional.orElse(null);
    }

    @Override
    public void update(T entity) {
        abstractBaseRepository.save(entity);
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = abstractBaseRepository.findById(entityId);
        if (optional.isPresent()) {
            return (T) abstractBaseRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        abstractBaseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        abstractBaseRepository.deleteById(entityId);
    }

}