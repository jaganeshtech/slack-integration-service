/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author udabhask
 */
public class BulkImportDataSet {
    
    private String name;
    private Map<String, String> fields;
    private List<Map<String,String>> syncActions;
    private String identifierFieldName;
    private String uri;
    private String updateRule;
    private boolean isSyncTriggeredOnImport;
    private boolean isUpdatingMultipleMatchedRecords;
    private String createdBy;
    private String createdAt;
    private String updatedBy;
    private String updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public List<Map<String, String>> getSyncActions() {
        return syncActions;
    }

    public void setSyncActions(List<Map<String, String>> syncActions) {
        this.syncActions = syncActions;
    }

    public String getIdentifierFieldName() {
        return identifierFieldName;
    }

    public void setIdentifierFieldName(String identifierFieldName) {
        this.identifierFieldName = identifierFieldName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUpdateRule() {
        return updateRule;
    }

    public void setUpdateRule(String updateRule) {
        this.updateRule = updateRule;
    }

    public boolean isIsSyncTriggeredOnImport() {
        return isSyncTriggeredOnImport;
    }

    public void setIsSyncTriggeredOnImport(boolean isSyncTriggeredOnImport) {
        this.isSyncTriggeredOnImport = isSyncTriggeredOnImport;
    }

    public boolean isIsUpdatingMultipleMatchedRecords() {
        return isUpdatingMultipleMatchedRecords;
    }

    public void setIsUpdatingMultipleMatchedRecords(boolean isUpdatingMultipleMatchedRecords) {
        this.isUpdatingMultipleMatchedRecords = isUpdatingMultipleMatchedRecords;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
