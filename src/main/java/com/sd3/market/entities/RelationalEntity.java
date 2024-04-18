package com.sd3.market.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class RelationalEntity {

    RelationalEntity(){
        LocalDateTime now = LocalDateTime.now();
        CreatedAt = now;
        UpdatedAt = now;
        Active = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID Id;
    @Column(name = "DT_CREATED_AT")
    private final LocalDateTime CreatedAt;
    @Column(name = "DT_UPDATED_AT")
    private LocalDateTime UpdatedAt;
    @Column(name = "ST_ACTIVE")
    private Boolean Active;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }
}
