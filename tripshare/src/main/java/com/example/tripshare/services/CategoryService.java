package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.CategoryMapper;
import com.example.tripshare.repositories.CategoryRepository;
import com.example.tripshare.models.entities.Category;
import com.example.tripshare.models.dtos.category.CategoryRequestDTO;
import com.example.tripshare.models.dtos.category.CategoryResponseDTO;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @SuppressWarnings("null")
    public CategoryResponseDTO create(CategoryRequestDTO request) {
        Category entity = categoryMapper.toEntity(request);
        Category saved = categoryRepository.save(entity);
        return categoryMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public CategoryResponseDTO getById(UUID id) {
        Category entity = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
        return categoryMapper.toDTO(entity);
    }

    @SuppressWarnings("null")
    public Page<CategoryResponseDTO> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable)
            .map(categoryMapper::toDTO);
    }

    @SuppressWarnings("null")
    public CategoryResponseDTO update(UUID id, CategoryRequestDTO request) {
        Category entity = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
        
        Category updated = categoryMapper.toEntity(request);
        updated.setId(entity.getId());
        
        Category saved = categoryRepository.save(updated);
        return categoryMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        Category entity = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
        categoryRepository.delete(entity);
    }
}
