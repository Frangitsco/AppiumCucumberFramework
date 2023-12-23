package com.qa.utils;

public class GlobalParams {
    private String platformName;
    private String deviceName;
    private String systemPort;
    private String chromeDriverPort;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }


    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSystemPort() {
        return systemPort;
    }

    public void setSystemPort(String systemPort) {
        this.systemPort = systemPort;
    }

    public String getChromeDriverPort() {
        return chromeDriverPort;
    }

    public void setChromeDriverPort(String chromeDriverPort) {
        this.chromeDriverPort = chromeDriverPort;
    }

    public void initializeGlobalParams() {
        setPlatformName(System.getProperty("platformName", "Android"));
        setDeviceName(System.getProperty("deviceName", "R3CR30Q97HV"));
        setSystemPort(System.getProperty("systemPort", "10000"));
        setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
    }
}


