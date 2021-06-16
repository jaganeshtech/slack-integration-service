/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eloqua.rs.eas.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author udabhask
 */
@Component
public class ServerDetails {
    
    /* Eloqua server details*/
    private static String companyName;
    private static String userName;
    private static String password;
    private static String cloud1Url;
     private static String bulk2Url;
    private static String proxyUrl;
    private static int proxyPort;
    private static String rest2Url;
    private static String instance;

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        ServerDetails.companyName = companyName;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        ServerDetails.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ServerDetails.password = password;
    }

    public static String getCloud1Url() {
        return cloud1Url;
    }

    public static void setCloud1Url(String cloud1Url) {
        ServerDetails.cloud1Url = cloud1Url;
    }

    public static String getBulk2Url() {
        return bulk2Url;
    }

    public static void setBulk2Url(String bulk2Url) {
        ServerDetails.bulk2Url = bulk2Url;
    }

    public static String getProxyUrl() {
        return proxyUrl;
    }

    public static void setProxyUrl(String proxyUrl) {
        ServerDetails.proxyUrl = proxyUrl;
    }

    public static int getProxyPort() {
        return proxyPort;
    }

    public static void setProxyPort(int proxyPort) {
        ServerDetails.proxyPort = proxyPort;
    }

    public static String getRest2Url() {
        return rest2Url;
    }

    public static void setRest2Url(String rest2Url) {
        ServerDetails.rest2Url = rest2Url;
    }

	public static String getInstance() {
		return instance;
	}

	public static void setInstance(String instance) {
		ServerDetails.instance = instance;
	}
        
}
