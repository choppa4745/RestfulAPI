package com.example.rest.service;

import com.example.rest.model.Category;

import java.util.UUID;

public interface CategoryServiceImpl extends UnitedModelService<Category, UUID> {

    Category findByName(String name);

}
