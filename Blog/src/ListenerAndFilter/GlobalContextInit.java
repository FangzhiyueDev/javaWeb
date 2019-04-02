package ListenerAndFilter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 全局应用程序的监听
 * 在里面实现对设置的一些加载
 *
 */
@WebListener
public class GlobalContextInit implements ServletContextListener {


    /**
		全局销毁时调用
    */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }
    
    /**
     * 应用程序初始化时调用
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        
    }
	
}
