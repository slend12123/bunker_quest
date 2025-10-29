<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<link rel="stylesheet" href="css/bunker.css">

<head>
    <title>Бункер</title>
</head>
<body>

<h2>Ты в бункере</h2>


<p><strong>${game.lastMessage}</strong></p>


<p>Здоровье: ${game.health}</p>
<p>Еда: ${game.food}</p>


<c:if test="${game.alive}">
    <form action="bunker" method="post">
        <button style="width: 150px; height: 50px;" name="action" value="eat">Поесть</button>
        <button style="width: 150px; height: 50px;" name="action" value="outside">Выйти на улицу</button>
        <button style="width: 150px; height: 50px;" name="action" value="sleep">Поспать</button>
    </form>
</c:if>


<c:if test="${!game.alive}">
    <form action="bunker" method="get">
        <button>Начать заново</button>
    </form>
</c:if>

</body>
</html>
