package com.example.rest.service;

import com.example.rest.model.Category;
import com.example.rest.model.Comment;

import java.util.Optional;
import java.util.UUID;

public interface CategoryService extends UnitedModelService<Category, UUID> {

    Category findByName(String name);

}
