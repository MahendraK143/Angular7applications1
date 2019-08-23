<%@ taglib prefix="util" uri="http://www.springframework.org/tags/form" %>
<%@ include file="home.jsp"%>

<%@ page import="java.util.Date" %>
<%@ page %>
LOVE YOU DARLING
<%@ page import="java.util.*" %>
<%! int i;%>
<% Date d = new Date(); out.print(d);%>
<%--
<%= String d = request.getParameter("hello"); out.print(d);%>--%>
<% if(request.getSession(false) == null){
}%>


<%! int i=6;%>
<% int j=8;%>
<%--<%= i*j %>--%>
<%@page language="java" %>%
<%@include file="<%= request.getParameter("file")%>"%>%
