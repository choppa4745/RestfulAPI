package com.example.rest.service.impl_services;

import com.example.rest.model.Category;
import com.example.rest.repository.CategoryRepository;
import com.example.rest.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.UUID;

public class CategoryServiceImpl extends AbstractUnitedModelServiceImpl<Category, UUID, CategoryRepository> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    protected Category updateFields(Category oldEntity, Category newEntity) {
        if (!Objects.equals(oldEntity.getName(), newEntity.getName())) {
            oldEntity.setName(newEntity.getName());
        }

        return oldEntity;
    }

    @Override
    public Category findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(
                        MessageFormat.format("Category with name {0} not found!", name)
                ));
    }
}

