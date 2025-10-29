<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Конец игры</title>
</head>
<body>

<h2>Ты умер</h2>
<p><c:out value="${game.lastMessage}"/></p>

<p>Ты продержался ${game.days} дней</p>

<form action="bunker" method="get">
    <input type="submit" value="Попробовать снова">
</form>

</body>
</html>
