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
    private boolean isadmin;

    public GroupMember() {}

    public GroupMember(UUID userId, UUID groupId, boolean isadmin) {
        this.userId = userId;
        this.groupId = groupId;
        this.isadmin = isadmin;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
}
