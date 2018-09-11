
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8" />
	<title>Wallpapers</title>
	<!--<meta firstName="keywords" content="" />
	<meta firstName="description" content="" />
-->
	<%--<script src="/resources/js/main.js"></script>--%>

</head>

<body>

<div class="page-bg">

</div>

<div class="wrapper">

	<header class="header">
        <div class="main">
            <div class="container"></div>
            <a href="index.html" class="logo"><img src="resources/img/logo2.png" style="width: 40px"></a>
            <nav>
                <ul>
                    <li><a href="index.html">Главная</a></li>
                    <li><a href="category.html">Категории</a></li>
                    <li onmousemove="changeColor()"><a href="list.jsp"><div id="button1">О нас</div></a></li>
                    <li><a href="contacts.xml">Контакты</a></li>
                </ul>

            </nav>
        </div>
	</header><!-- .header-->

<%--<form method="post">--%>
    <%--<label for="age">Age: </label>--%>
    <%--<input id="age" name="age" type="text"/>--%>
    <%--<label for="email">EMail: </label>--%>
    <%--<input id="email" name="email" type="email"/>--%>
    <%--<label for="firstName">Name: </label>--%>
    <%--<input id="firstName" name="firstName" type="text"/>--%>
    <%--<label for="password">Password: </label>--%>
    <%--<input id="password" name="password" type="password"/>--%>
    <%--<button id="button" onclick="submitStuff()">Submit</button>--%>
<%--</form>--%>

	<main class="content">
        <table>
            <tr>
                <td onmousemove="showHideMove()"><div id="img"><img src="resources/img/1.jpg" style="width: 370px;height: 250px;"></div></td>
                <td onclick="ShowHideClick()"><div id="imgSecond"><img src="resources/img/2.jpg" style="width: 370px;height: 250px;"></div></td>
                <td><img src="resources/img/2.jpg" style="width: 370px;height: 250px;"></td>
            </tr>
            <tr>
                <td><img src="resources/img/3.jpg" style="width: 370px;height: 250px;"></td>
                <td><img src="resources/img/4.jpg" style="width: 370px;height: 250px;"></td>
                <td><img src="resources/img/2.jpg" style="width: 370px;height: 250px;"></td>
            </tr>
            <tr>
                <td><img src="resources/img/3.jpg" style="width: 370px;height: 250px;"></td>
                <td><img src="resources/img/4.jpg" style="width: 370px;height: 250px;"></td>
                <td><img src="resources/img/2.jpg" style="width: 370px;height: 250px;"></td>
            </tr>
        </table>
    </main><!-- .content -->

</div><!-- .wrapper -->

<footer class="footer"></footer><!-- .footer -->

	<!--<link href="assets/css/reset.css" rel="stylesheet">-->
	<link href="resources/css/style.css" rel="stylesheet">
    <script src="resources/js/script.js"></script>
</body>
</html>