package com.example.tripshare.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Table(name = "group_members")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class GroupMember {

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor do campo 'user_id' não pode estar vazio")
    private User userId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor de 'group_id' não pode estar vazio")
    private Group groupId;

    @Builder.Default
    @NotNull(message = "O valor do atributo 'is_admin' não pode estar vazio")
    @Column(nullable = false)
    private Boolean isAdmin = false;

    @Builder.Default
    @NotNull(message = "O valor do atributo 'in_group' não pode estar vazio")
    private Boolean inGroup = true;
    
    @CreationTimestamp
    @NotNull(message = "O valor do atributo 'joined_at' não pode estar vazio")
    private LocalDateTime joinedAt;

    private LocalDateTime leftAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getInGroup() {
        return inGroup;
    }

    public void setInGroup(Boolean inGroup) {
        this.inGroup = inGroup;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDateTime joinedAt) {
        this.joinedAt = joinedAt;
    }

    public LocalDateTime getLeftAt() {
        return leftAt;
    }

    public void setLeftAt(LocalDateTime leftAt) {
        this.leftAt = leftAt;
    }
}
