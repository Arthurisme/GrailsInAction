<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 2015-11-09
  Time: 21:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Random Quote</title>
    <g:javascript library="jquery" />
</head>
<body>
<div id="quote">
    <q>${quote.content}</q>
    <p>${quote.author}</p>



    <ul id="menu">
        <li>
            <g:remoteLink action="ajaxRandom" update="quote">
                Next Quote
            </g:remoteLink>
        </li>
        <li>
            <g:link action="index">
                Admin
            </g:link>
        </li>
    </ul>

</div>
</body>
</html>