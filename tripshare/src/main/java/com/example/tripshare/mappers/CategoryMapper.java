package com.example.tripshare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.tripshare.models.dtos.category.CategoryRequestDTO;
import com.example.tripshare.models.dtos.category.CategoryResponseDTO;
import com.example.tripshare.models.entities.Category;



@Mapper(componentModel = "spring")
public interface CategoryMapper {
    
    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryRequestDTO request);

    CategoryResponseDTO toDTO(Category paymentSplit);

}
