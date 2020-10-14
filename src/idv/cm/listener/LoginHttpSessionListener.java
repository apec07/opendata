package idv.cm.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class LoginHttpSessionListener
 *
 */
@WebListener
public class LoginHttpSessionListener implements HttpSessionBindingListener {

    public ServletContext context;
    
    public LoginHttpSessionListener() {
    	
    }
    
    public LoginHttpSessionListener(ServletContext context) {
        this.context = context;
    }


    public void valueBound(HttpSessionBindingEvent event)  { 
         System.out.println("valueBound");
         context.log("bound name = "+event.getName()+",ID - "+event.getSession().getId());
    }


    public void valueUnbound(HttpSessionBindingEvent event)  { 
    	 System.out.println("valueUnBound");
         context.log("unbound name = "+event.getName()+",ID - "+event.getSession().getId());

    }
	
}
