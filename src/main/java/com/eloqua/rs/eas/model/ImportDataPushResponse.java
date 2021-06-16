/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

/**
 *
 * @author udabhask
 */
public class ImportDataPushResponse {
    
   private String syncedInstanceUri;
   private String syncStartedAt;
   private String syncEndedAt;
   private String status;
   private String createdAt;   
   private String createdBy;
   private String uri;

   public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSyncedInstanceUri() {
        return syncedInstanceUri;
    }

    public void setSyncedInstanceUri(String syncedInstanceUri) {
        this.syncedInstanceUri = syncedInstanceUri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSyncStartedAt() {
        return syncStartedAt;
    }

    public void setSyncStartedAt(String syncStartedAt) {
        this.syncStartedAt = syncStartedAt;
    }

    public String getSyncEndedAt() {
        return syncEndedAt;
    }

    public void setSyncEndedAt(String syncEndedAt) {
        this.syncEndedAt = syncEndedAt;
    }
    
    
}
