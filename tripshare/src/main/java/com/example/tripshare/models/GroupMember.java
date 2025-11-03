package com.example.tripshare.models;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "group_members")
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private UUID groupId;

    @Column(nullable = false)
    private boolean isAdmin;

    public GroupMember() {}

    public GroupMember(UUID userId, UUID groupId, boolean isAdmin) {
        this.userId = userId;
        this.groupId = groupId;
        this.isAdmin = isAdmin;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
