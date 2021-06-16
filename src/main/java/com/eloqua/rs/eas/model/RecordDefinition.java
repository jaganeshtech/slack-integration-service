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
public class RecordDefinition {

//    private String contactID;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String titleGiven;
    private String companyGiven;
//    private String workPhoneNumber;
//    private String address;
//    private String city;
//    private String state;
//    private String zipcode;
//    private String country;
//    private String campaignCode;
//    private String lastFormSubmittedName;
//    private String lastFormSubmittedDate;
//    private String Salesperson;
//    
//    private String OracleSalesCloudAccountID;
//    private String RegistrantNoLeadFlow;
//    private String OracleSalesCloudContactID;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitleGiven() {
        return titleGiven;
    }

    public void setTitleGiven(String titleGiven) {
        this.titleGiven = titleGiven;
    }

    public String getCompanyGiven() {
        return companyGiven;
    }

    public void setCompanyGiven(String companyGiven) {
        this.companyGiven = companyGiven;
    }

    @Override
    public String toString() {
        return "RecordDefinition{" + "emailAddress=" + emailAddress + ", firstName=" + firstName + ", lastName=" + lastName + ", titleGiven=" + titleGiven + ", companyGiven=" + companyGiven + '}';
    }

   

   
}
