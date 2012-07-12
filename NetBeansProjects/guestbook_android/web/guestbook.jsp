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



<html>
  <head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css" />
  </head>

  <body>

<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
%>
<p>Hello, <%= user.getNickname() %>! (You can
<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p>
<%
    } else {
%>
<p>Hello!
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
to include your name with greetings you post.</p>
<%
    }
%>

<%
    PersistenceManager pm = PMF.get().getPersistenceManager();
    String query = "select from " + Greeting.class.getName() + " order by date desc range 0,5";
    List<Greeting> greetings = (List<Greeting>) pm.newQuery(query).execute();
    if (greetings.isEmpty()) {
%>
<p>The guestbook has no messages.</p>
<%
    } else {
        for (Greeting g : greetings) {
            if (g.getAuthor() == null) {
%>
<p>An anonymous person wrote:</p>
<%
            } else {
%>
<p><b><%= g.getAuthor().getNickname() %></b> wrote:</p>
<%
            }
%>
<%
     String[] ids = TimeZone.getAvailableIDs(-5 * 60 * 60 * 1000);
     SimpleTimeZone est = new SimpleTimeZone(-5 * 60 * 60 * 1000, ids[0]); 
     SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy G 'at' HH:mm:ss z");
     sdf2.setTimeZone(TimeZone.getTimeZone("America/New_York"));
 %>
<blockquote><%= g.getContent() %></blockquote>
<blockquote><%= sdf2.format(g.getDate()) %></blockquote>
<%
        }
    }
    pm.close();
%>

    <form action="/sign" method="post">
      <div><textarea name="content" rows="3" cols="60"></textarea></div>
      <div><input type="submit" value="Post Greeting" /></div>
    </form>

  </body>
</html>
