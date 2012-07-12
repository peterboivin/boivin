<%-- 
    Document   : index
    Created on : Sep 14, 2011, 9:48:32 PM
    Author     : peterboivin
--%>
<%@page import="java.util.TimeZone"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="guestbook.Greeting" %>
<%@ page import="guestbook.PMF" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.SimpleTimeZone"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <b><%= request.getParameter("message") %></b>
    </body>
</html>
