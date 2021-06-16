/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

/**
 *
 * @author pmanoor
 */
public enum SyncActionType
    {
        add(1),
        remove(2),
        subscribe(3),
        unsubscribe(4),
        markActive(5),
        markComplete(6);
    
    private int numVal;

    SyncActionType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
    }
