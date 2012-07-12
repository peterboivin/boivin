/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boivin.android;

/**
 *
 * @author peterboivin
 */

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import java.util.Date;
import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import java.util.logging.Logger;

 
@SuppressWarnings("serial")
public class ListenForRestClientServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String message = "NONE";
 
        resp.setContentType("text/html");
 
        if (req.getParameterMap().containsKey("message"))
            message = req.getParameter("message");
            System.out.println("Message: " + message);
 
        resp.getWriter().println("You said: " + message);
        
                UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        String content = req.getParameter("message");
        Date date = new Date();
        Greeting greeting = new Greeting(user, content, date);

        //<editor-fold defaultstate="collapsed" desc="Persistence Manager">
        PersistenceManager
                //</editor-fold>
 pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(greeting);
        } finally {
            pm.close();
        }
    }
}