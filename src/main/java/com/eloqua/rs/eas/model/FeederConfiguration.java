/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

import java.util.List;

/**
 *
 * @author ganeshraja
 */
public class FeederConfiguration {

    private String eventId;
    private String eventType;
    private List<FieldMappings> fieldMappings;
    private SyncConfiguration syncConfiguration;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public List<FieldMappings> getFieldMappings() {
        return fieldMappings;
    }

    public void setFieldMappings(List<FieldMappings> fieldMappings) {
        this.fieldMappings = fieldMappings;
    }

    public SyncConfiguration getSyncConfiguration() {
        return syncConfiguration;
    }

    public void setSyncConfiguration(SyncConfiguration syncConfiguration) {
        this.syncConfiguration = syncConfiguration;
    }


   
}
