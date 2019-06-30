package com.deng.starter;

import com.deng.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

/**
 * 入口类
 *
 * @author DengYongQi
 * @date 2019-06-30
 **/
public class MiniApplication {
    public static void run(Class<?> cls, String[] args) {
        System.out.println("Hello mini-spring application !");

        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
