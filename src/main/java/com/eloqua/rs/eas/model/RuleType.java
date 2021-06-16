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
public enum RuleType {
            always(1),
            ifNewIsNotNull(2),
            ifExistingIsNull(6),
            useFieldRule(17);
            
    private int numVal;

    RuleType(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
    

}
