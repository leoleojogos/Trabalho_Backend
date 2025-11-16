package com.example.tripshare.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.AllArgsConstructor;

import java.util.UUID;
import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

@Table(name = "group_members")
@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class GroupMember extends AuditableEntity{

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor do campo 'user_id' não pode estar vazio")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O valor de 'group_id' não pode estar vazio")
    private Group groupId;

    @NotNull(message = "O valor do atributo 'is_admin' não pode estar vazio")
    @Column(nullable = false)
    private Boolean isAdmin;

    @Builder.Default
    @NotNull(message = "O valor do atributo 'in_group' não pode estar vazio")
    private Boolean inGroup = true;

    private LocalDateTime leftAt;

}
