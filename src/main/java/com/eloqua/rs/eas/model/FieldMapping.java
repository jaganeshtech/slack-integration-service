/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

/**
 *
 * @author ganeshraja
 */
public class FieldMapping {
    private String name;
    private String internalName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    public FieldMapping() {}

    public FieldMapping(String name, String internalName) {
        this.name = name;
        this.internalName = internalName;
    }
}
