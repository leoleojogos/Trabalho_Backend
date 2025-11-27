package com.example.tripshare.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.tripshare.services.GroupService;
import com.example.tripshare.models.dtos.group.GroupRequestDTO;
import com.example.tripshare.models.dtos.group.GroupResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupResponseDTO> create(@Valid @RequestBody GroupRequestDTO request) {
        GroupResponseDTO response = groupService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> getById(@PathVariable UUID id) {
        GroupResponseDTO response = groupService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<GroupResponseDTO>> getAll(Pageable pageable) {
        Page<GroupResponseDTO> response = groupService.getAll(pageable);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GroupResponseDTO> update(@PathVariable UUID id, @RequestBody GroupRequestDTO request) {
        GroupResponseDTO response = groupService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
