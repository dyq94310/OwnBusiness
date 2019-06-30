package com.deng.web.server;

import com.deng.web.servlet.TestServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author DengYongQi
 * @date 2019-06-30
 **/
public class TomcatServer {
    private Tomcat tomcat;

    private String[] agrs;

    public TomcatServer(String[] agrs) {
        this.agrs = agrs;
    }

    public void startServer() throws LifecycleException {
        //实例化tomcat
        tomcat = new Tomcat();
        tomcat.start();

        //实例化context容器
        Context context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        TestServlet servlet = new TestServlet();
        Tomcat.addServlet(context, "servlet", servlet).setAsyncSupported(true);

        //添加URL映射
        context.addServletMappingDecoded("/test", "servlet");
        tomcat.getHost().addChild(context);
        //设置守护线程防止tomcat中途退出
        Thread awaitThread = new Thread("tomcat_await_thread.") {
            @Override
            public void run() {
                //内部类使用外部类类名
                TomcatServer.this.tomcat.getServer().await();
            }
        };

        //设置为非守护线程
        awaitThread.setDaemon(false);
        awaitThread.start();
    }
}
