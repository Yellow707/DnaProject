<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.* " %>
<%@ page import="java.io.*" %>

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
                    <li onmousemove="changeColor()"><a href=""><div id="button1">О нас</div></a></li>
                    <li><a href="contacts.xml">Контакты</a></li>
                </ul>

            </nav>
        </div>
    </header><!-- .header-->

    <form id="pform">
        <label for="age">Age: </label>
        <input id="age" name="age" type="text"/>
        <label for="email">EMail: </label>
        <input id="email" name="email" type="email"/>
        <label for="firstName">Name: </label>
        <input id="firstName" name="firstName" type="text"/>
        <label for="password">Password: </label>
        <input id="password" name="password" type="password"/>
        <input type="submit" value="Save">
    </form>

    <main class="content">


        <%
            try {
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/postgres";
                String username = "postgres";
                String password = "123321";
                String myDataField = null;
                String myQuery = "SELECT * FROM USERS";
                Connection myConnection = null;
                PreparedStatement myPreparedStatement = null;
                ResultSet myResultSet = null;
                Class.forName(driver).newInstance();
                myConnection = DriverManager.getConnection(url,username,password);
                myPreparedStatement = myConnection.prepareStatement(myQuery);
                myResultSet = myPreparedStatement.executeQuery();
                out.println("<table border=\"1\"> <tr><th>Name</th><th>Password</th><th>Age</th><th>Email</th></tr>");
                while (myResultSet.next()) {
                    String firstName = myResultSet.getString("firstname");
                    String password1 = myResultSet.getString("password");
                    Integer age = myResultSet.getInt("age");
                    String email = myResultSet.getString("email");
                    out.println("<tr><td>" + firstName + "</td>");
                    out.println("<td>" + password1 + "</td>");
                    out.println("<td>" + age + "</td>");
                    out.println("<td>" + email + "</td></tr>");
                    //out.println("\n===================\n" + "<br />");
                }
                out.println("</table>");
            }
            catch(ClassNotFoundException e){e.printStackTrace();}
            catch (SQLException ex)
            {
                out.print("SQLException: "+ex.getMessage());
                out.print("SQLState: " + ex.getSQLState());
                out.print("VendorError: " + ex.getErrorCode());
            }
        %>

        <table id="jstable">

        </table>
    </main><!-- .content -->

</div><!-- .wrapper -->

<footer class="footer"></footer><!-- .footer -->

<!--<link href="assets/css/reset.css" rel="stylesheet">-->
<link href="resources/css/style.css" rel="stylesheet">
<script src="resources/js/script.js"></script>
</body>
</html>