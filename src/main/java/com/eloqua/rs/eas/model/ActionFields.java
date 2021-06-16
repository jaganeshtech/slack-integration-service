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
public class ActionFields {
    
    private RecordDefinition recordDefinition;
    private String requiresConfiguration;

    public RecordDefinition getRecordDefinition() {
        return recordDefinition;
    }

    public void setRecordDefinition(RecordDefinition recordDefinition) {
        this.recordDefinition = recordDefinition;
    }

    public String getRequiresConfiguration() {
        return requiresConfiguration;
    }

    public void setRequiresConfiguration(String requiresConfiguration) {
        this.requiresConfiguration = requiresConfiguration;
    }
    
    
    
}
