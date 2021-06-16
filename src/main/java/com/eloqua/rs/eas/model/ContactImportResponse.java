/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eloqua.rs.eas.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author sbarengo
 */
public class ContactImportResponse {
String name;
String updateRule;
//Map<String,String> fields;
List<Map<String,String>> fields;

String identifierFieldName;
List<Map<String, String>> syncActions;
boolean isSyncTriggeredOnImport;
int secondsToRetainData;
String uri;
String createdBy;
String createdAt;
String updatedBy;
String updatedAt;

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


    public String getIdentifierFieldName() {
        return identifierFieldName;
    }

    public void setIdentifierFieldName(String identifierFieldName) {
        this.identifierFieldName = identifierFieldName;
    }

    public boolean isIsSyncTriggeredOnImport() {
        return isSyncTriggeredOnImport;
    }

    public void setIsSyncTriggeredOnImport(boolean isSyncTriggeredOnImport) {
        this.isSyncTriggeredOnImport = isSyncTriggeredOnImport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSecondsToRetainData() {
        return secondsToRetainData;
    }

    public void setSecondsToRetainData(int secondsToRetainData) {
        this.secondsToRetainData = secondsToRetainData;
    }

    public List<Map<String, String>> getSyncActions() {
        return syncActions;
    }

    public void setSyncActions(List<Map<String, String>> syncActions) {
        this.syncActions = syncActions;
    }

    public String getUpdateRule() {
        return updateRule;
    }

    public void setUpdateRule(String updateRule) {
        this.updateRule = updateRule;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Map<String, String>> getFields() {
        return fields;
    }

    public void setFields(List<Map<String, String>> fields) {
        this.fields = fields;
    }

    
    
}
