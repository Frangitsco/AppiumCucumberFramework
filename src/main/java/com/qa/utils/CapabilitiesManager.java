package com.qa.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CapabilitiesManager {

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
       // caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

        // Only set capabilities for Android since we are not running iOS tests.
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
        caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
        caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
        caps.setCapability("systemPort", params.getSystemPort());
        caps.setCapability("chromeDriverPort", params.getChromeDriverPort());

        String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                + File.separator + "resources" + File.separator + "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
        System.out.println("App URL is: " + androidAppUrl);
        caps.setCapability("app", androidAppUrl);

        return caps;
    }
}

