package com.qa.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;

public class Hooks {

    @Before
    public void initialize(){
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        new ServerManager().startServer();
    }

    @After
    public void quit(){
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
    }
}
