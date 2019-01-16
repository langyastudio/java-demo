<%--
  Created by IntelliJ IDEA.
  User: hk
  Date: 2019/1/15
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.servlet.common.UserInfoList" %>
<%@ page import="com.servlet.common.UserInfoTrace" %>

<html>
<head>
    <title>online num</title>
</head>
<body>
<%
    UserInfoList userList = UserInfoList.getInstance();
    UserInfoTrace userTrace = new UserInfoTrace();
    String name = request.getParameter("user");

    userTrace.setUser(name);
    session.setAttribute("list", userTrace);
    userList.addUserInfo(userTrace.getUser());
    session.setMaxInactiveInterval(10);
%>
<textarea rows="8" cols="20">
<%
    HashSet set = userList.getList();
    if (set != null && set.size() > 0) {
        Iterator setIter = set.iterator();

        while (setIter.hasNext()) {
            out.println(setIter.next());
        }
    }
%>
</textarea>
</body>
</html>
