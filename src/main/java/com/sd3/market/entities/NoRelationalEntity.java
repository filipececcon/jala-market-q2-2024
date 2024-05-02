package com.sd3.market.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@MappedSuperclass
public abstract class NoRelationalEntity {

    public NoRelationalEntity(){
        Active = true;
        id = new ObjectId();
    }

    @MongoId
    @Field("_id")
    private ObjectId id;
    @Field("dt_created_at")
    private LocalDateTime CreatedAt;
    @Field("dt_updated_at")
    private LocalDateTime UpdatedAt;
    @Setter
    @Field("st_active")
    private Boolean Active;

    public String getStringId(){
        return getId().toHexString();
    }

    private void setId(ObjectId id) {
        this.id = id;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    private void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    public void update(){
        this.UpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate(){
        UpdatedAt = LocalDateTime.now();
    }

    @PrePersist
    void onCreate(){
        CreatedAt = LocalDateTime.now();
    }

    @PostUpdate
    void postPersist(){
        System.out.println("[UPDATE]" + this.getClass().getName() +" - id:" + getId());
    }

}
