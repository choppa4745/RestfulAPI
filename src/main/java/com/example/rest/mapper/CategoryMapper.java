package com.example.rest.mapper;

import com.example.rest.model.Category;
import com.example.rest.web.model.request.UpsertCategoryRequest;
import com.example.rest.web.model.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CategoryMapper {

    Category upsertRequestToCategory(UpsertCategoryRequest request);

    CategoryResponse categoryToResponse(Category category);

}