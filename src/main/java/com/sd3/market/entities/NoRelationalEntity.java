package com.sd3.market.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class NoRelationalEntity {

    NoRelationalEntity(){
        LocalDateTime now = LocalDateTime.now();
        CreatedAt = now;
        UpdatedAt = now;
        Active = true;
        id = new ObjectId();
        //Id = UUID.randomUUID().toString().replace("-","");
    }

    @MongoId
    @Field("_id")
    private ObjectId id;
    @Field("dt_created_at")
    private LocalDateTime CreatedAt;
    @Field("dt_updated_at")
    private LocalDateTime UpdatedAt;
    @Field("st_active")
    private Boolean Active;

    public ObjectId getId() {
        return id;
    }

    public String getStringId(){
        return getId().toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    private void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public void update(){
        this.UpdatedAt = LocalDateTime.now();
    }

}
