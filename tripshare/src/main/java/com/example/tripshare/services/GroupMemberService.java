package com.example.tripshare.services;

import com.example.tripshare.models.entities.Group;
import com.example.tripshare.models.entities.GroupMember;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class GroupMemberService {
    private final List<GroupMember> members = new ArrayList<>();

    public GroupMember addMember(UUID groupId, UUID userId, UUID adminUserId) {
        validateAdmin(groupId, adminUserId);

        GroupMember newMember = new GroupMember();
        newMember.setId(UUID.randomUUID());
        newMember.setGroupId((new Group(groupId)));
        newMember.setUserId(new User(userId));
        newMember.setAdmin(false);
        newMember.setInGroup(true);
        
        members.add(newMember);
        return newMember;
    }

    public void removeMember(UUID groupId, UUID userId, UUID adminUserId) {
        validateAdmin(groupId, adminUserId);

        GroupMember member = findMember(groupId, userId);
        members.remove(member);
    }

    public GroupMember makeAdmin(UUID groupId, UUID userId, UUID adminUserId) {
        validateAdmin(groupId, adminUserId);

        GroupMember member = findMember(groupId, userId);
        member.setAdmin(true);
        return member;
    }

    public void leaveGroup(UUID groupId, UUID userId) {
        GroupMember member = findMember(groupId, userId);

        member.setGroupId(false);
        member.setLeftAt(LocalDateTime.now());
    }

    public List<GroupMember> listMembers(UUID groupId) {
        return members.stream()
                .filter(m -> m.getGroupId().getId().equals(groupId) && m.getInGroup())
                .collect(Collectors.toList());
    }


    private GroupMember findMember(UUID groupId, UUID userId) {
        return members.stream()
                .filter(m ->
                        m.getGroupId().getId().equals(groupId) &&
                        m.getUserId().getId().equals(userId) &&
                        m.getInGroup()
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Membro não encontrado"));
    }

    private void validateAdmin(UUID groupId, UUID adminId) {
        boolean isAdmin = members.stream()
                .anyMatch(m ->
                        m.getGroupId().getId().equals(groupId) &&
                        m.getUserId().getId().equals(adminId) &&
                        Boolean.TRUE.equals(m.getAdmin()) &&
                        m.getInGroup()
                );

        if(!isAdmin) {
            throw new RuntimeException("Apenas administradores podem realizar esta ação");
        }
    }
}
