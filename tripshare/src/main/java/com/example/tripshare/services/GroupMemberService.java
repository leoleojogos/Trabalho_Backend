package com.example.tripshare.services;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tripshare.mappers.GroupMemberMapper;
import com.example.tripshare.repositories.GroupMemberRepository;
import com.example.tripshare.repositories.UserRepository;
import com.example.tripshare.repositories.GroupRepository;
import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.models.entities.User;
import com.example.tripshare.models.entities.Group;
import com.example.tripshare.models.dtos.groupMember.GroupMemberRequestDTO;
import com.example.tripshare.models.dtos.groupMember.GroupMemberResponseDTO;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupMemberService {
    
    private final GroupMemberRepository groupMemberRepository;
    private final GroupMemberMapper groupMemberMapper;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @SuppressWarnings("null")
    public GroupMemberResponseDTO create(GroupMemberRequestDTO request) {
        User user = userRepository.findById(request.userId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + request.userId()));
        
        Group group = groupRepository.findById(request.groupId())
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado com id: " + request.groupId()));
        
        GroupMember entity = groupMemberMapper.toEntity(request);
        entity.setUserId(user);
        entity.setGroupId(group);
        entity.setIsAdmin(false);
        entity.setInGroup(true);
        
        GroupMember saved = groupMemberRepository.save(entity);
        return groupMemberMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public GroupMemberResponseDTO getById(UUID id) {
        GroupMember entity = groupMemberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Membro do grupo não encontrado com id: " + id));
        return groupMemberMapper.toDTO(entity);
    }

    @SuppressWarnings("null")
    public Page<GroupMemberResponseDTO> getAll(Pageable pageable) {
        return groupMemberRepository.findAll(pageable)
            .map(groupMemberMapper::toDTO);
    }

    @SuppressWarnings("null")
    public GroupMemberResponseDTO update(UUID id, GroupMemberRequestDTO request) {
        GroupMember entity = groupMemberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Membro do grupo não encontrado com id: " + id));
        
        User user = userRepository.findById(request.userId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + request.userId()));
        
        Group group = groupRepository.findById(request.groupId())
            .orElseThrow(() -> new RuntimeException("Grupo não encontrado com id: " + request.groupId()));
        
        entity.setUserId(user);
        entity.setGroupId(group);
        
        GroupMember saved = groupMemberRepository.save(entity);
        return groupMemberMapper.toDTO(saved);
    }

    @SuppressWarnings("null")
    public void delete(UUID id) {
        GroupMember entity = groupMemberRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Membro do grupo não encontrado com id: " + id));
        groupMemberRepository.delete(entity);
    }
}
