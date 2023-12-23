package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class ServerManager {
    private AppiumDriverLocalService server;

    public AppiumDriverLocalService getServer() {
        return server;
    }

    public void startServer() {
        System.out.println("Starting Appium server on Mac");
        server = MacGetAppiumService();
        server.start();
        System.out.println("Appium server started");
        if (!server.isRunning()) {
            System.out.println("Appium server not started. ABORT!!!");
            throw new RuntimeException("Appium server not started. ABORT!!!");
        }
        System.out.println("Appium server started");
    }

    private AppiumDriverLocalService MacGetAppiumService() {
        GlobalParams params = new GlobalParams();
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/usr/local/Cellar/openjdk/20.0.2/libexec/openjdk.jdk/Contents/Home/bin:/usr/local/bin:/System/Cryptexes/App/usr/bin:/usr/bin:/bin:/usr/sbin:/sbin:" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/cex/Library/Android/sdk");
     //   environment.put("JAVA_HOME", System.getenv("JAVA_HOME"));

        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withEnvironment(environment));
    }

    public void stopServer() {
        if (server != null) {
            server.stop();
            System.out.println("Appium server stopped");
        }
    }
}