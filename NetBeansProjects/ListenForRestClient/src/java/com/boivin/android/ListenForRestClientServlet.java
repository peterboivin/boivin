/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boivin.android;

/**
 *
 * @author peterboivin
 */

import java.io.IOException;
import javax.servlet.http.*;
 
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
    }
}