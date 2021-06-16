package com.eloqua.rs.eas.model;

import java.util.Map;

/**
 *
 * @author pmanoor
 */
public class ContactImportSet {

    private String emailAddress;
    private Map<String, String> elementData;

    public Map<String, String> getElementData() {
        return elementData;
    }

    public void setElementData(Map<String, String> elementData) {
        this.elementData = elementData;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
