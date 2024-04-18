package com.sd3.market.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class NoRelationalEntity {

    NoRelationalEntity(){
        LocalDateTime now = LocalDateTime.now();
        CreatedAt = now;
        UpdatedAt = now;
        Active = true;
        Id = UUID.randomUUID().toString().replace("-","");
    }

    @Id
    @Field("_id")
    private String Id;
    @Field("dt_created_at")
    private LocalDateTime CreatedAt;
    @Field("dt_updated_at")
    private LocalDateTime UpdatedAt;
    @Field("st_active")
    private Boolean Active;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
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
