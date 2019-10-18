<%--
  Created by IntelliJ IDEA.
  User: hk
  Date: 2018/12/27
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>test</title>
  </head>
  <body>
    <h2>
      欢迎光临，<br>
      您是本站的第【
      <%= application.getAttribute("count") %>
      】位访客！
    </h2><hr>

    <form action="/java_servlet/test" method="post">
        <table align="center" border="1" width="350">
            <tr>
                <td  class="2" align="center" colspan="2">
                    <h2>添加图书信息</h2>
                </td>
            </tr>
            <tr>
                <td align="right">图书编号：</td>
                <td>
                    <input type="text" name="id">
                </td>
            </tr>
            <tr>
                <td align="right">图书名称：</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td align="right">作    者：</td>
                <td>
                    <input type="text" name="author">
                </td>
            </tr>
            <tr>
                <td align="right">价    格：</td>
                <td>
                    <input type="text" name="price">
                </td>
            </tr>
            <tr>
                <td  class="2" align="center" colspan="2">
                    <input type="submit" value="添  加">
                </td>
            </tr>
        </table>
    </form>

  </body>
</html>
