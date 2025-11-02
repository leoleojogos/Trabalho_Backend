package com.example.tripshare.models;

import java.util.UUID;

public class GroupMember {
    private UUID participantId;
    private UUID groupId;
    private boolean isAdmin;

    public GroupMember(UUID participantId, UUID groupId, boolean isAdmin) {
        this.participantId = participantId;
        this.groupId = groupId;
        this.isAdmin = isAdmin;
    }

    public UUID getParticipantId() {
        return participantId;
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
