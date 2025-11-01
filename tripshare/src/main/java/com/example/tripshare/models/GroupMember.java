package com.example.tripshare.models;

import java.util.UUID;

public class GroupMember {
    private UUID userId;
    private UUID groupId;
    private boolean isadmin;

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
