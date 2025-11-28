package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.GroupMapper;
import com.example.tripshare.repositories.GroupRepository;
import com.example.tripshare.repositories.UserRepository;
import com.example.tripshare.models.entities.Group;
import com.example.tripshare.models.entities.User;
import com.example.tripshare.models.dtos.group.GroupRequestDTO;
import com.example.tripshare.models.dtos.group.GroupResponseDTO;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final UserRepository userRepository;

    @SuppressWarnings("null")
    public GroupResponseDTO create(GroupRequestDTO request) {
        User creator = userRepository.findById(request.createdById())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + request.createdById()));
        
        Group entity = groupMapper.toEntity(request);
        entity.setCreatedBy(creator);
        Group saved = groupRepository.save(entity);
        return groupMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public GroupResponseDTO getById(UUID id) {
        Group entity = groupRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado com id: " + id));
        return groupMapper.toDTO(entity);
    }

    @SuppressWarnings("null")
    public Page<GroupResponseDTO> getAll(Pageable pageable) {
        return groupRepository.findAll(pageable)
            .map(groupMapper::toDTO);
    }

    @SuppressWarnings("null")
    public GroupResponseDTO update(UUID id, GroupRequestDTO request) {
        Group entity = groupRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado com id: " + id));
        
        User creator = userRepository.findById(request.createdById())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + request.createdById()));
        
        Group updated = groupMapper.toEntity(request);
        updated.setId(entity.getId());
        updated.setCreatedAt(entity.getCreatedAt());
        updated.setCreatedBy(creator);
        
        Group saved = groupRepository.save(updated);
        return groupMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        Group entity = groupRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado com id: " + id));
        groupRepository.delete(entity);
    }
}
