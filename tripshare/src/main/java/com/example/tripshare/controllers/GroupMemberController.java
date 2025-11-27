package com.example.tripshare.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.tripshare.services.GroupMemberService;
import com.example.tripshare.models.dtos.groupMember.GroupMemberRequestDTO;
import com.example.tripshare.models.dtos.groupMember.GroupMemberResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@RestController
@RequestMapping("/api/group-members")
@RequiredArgsConstructor
public class GroupMemberController {
    
    private final GroupMemberService groupMemberService;

    @PostMapping
    public ResponseEntity<GroupMemberResponseDTO> create(@Valid @RequestBody GroupMemberRequestDTO request) {
        GroupMemberResponseDTO response = groupMemberService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupMemberResponseDTO> getById(@PathVariable UUID id) {
        GroupMemberResponseDTO response = groupMemberService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<GroupMemberResponseDTO>> getAll(Pageable pageable) {
        Page<GroupMemberResponseDTO> response = groupMemberService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupMemberResponseDTO> update(@PathVariable UUID id, @Valid @RequestBody GroupMemberRequestDTO request) {
        GroupMemberResponseDTO response = groupMemberService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        groupMemberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
