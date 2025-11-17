package com.example.tripshare.controllers;

import com.example.tripshare.models.entities.GroupMember;
import com.example.tripshare.services.GroupMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/group/{groupId}/members")
public class GroupMemberController {
    private final GroupMemberService groupMemberService;

    public GroupMemberController(GroupMemberService groupMemberService) {
        this.groupMemberService = groupMemberService;
    }

    public ResponseEntity<GroupMember> addMember(
            @PathVariable UUID groupId,
            @RequestParam UUID userId,
            @RequestParam UUID adminUserId
    ) {
        GroupMember member = groupMemberService.addMember(groupId, userId, adminUserId);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @PatchMapping("/{userId}/admin")
    public ResponseEntity<GroupMember> makeAdmin(
            @PathVariable UUID groupId,
            @PathVariable UUID userId,
            @RequestParam UUID adminUserId
    ) {
        GroupMember updated = groupMemberService.makeAdmin(groupId, userId, adminUserId);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/sair")
    public ResponseEntity<Void> leaveGroup(
            @PathVariable UUID groupId,
            @RequestParam UUID userId
    ) {
        groupMemberService.leaveGroup(groupId, userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<GroupMember>> listGroupMembers(@PathVariable UUID groupId) {
        return ResponseEntity.ok(groupMemberService.listMembers(groupId));
    }
}
