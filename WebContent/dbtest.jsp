<%@page import="com.us.g2g.hbm.User"%>
<%@page import="com.us.g2g.hbm.UserHome"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

UserHome home = new UserHome();

User user = home.findById(1);

out.print(user.getEmail());

user = home.findById("agni2020@gmail.com");

out.print(user.getPassword());
%>
</body>
</html>