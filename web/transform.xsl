<?xml version="1.0" encoding="utf-8" ?>
<!-- Версия и тип XSLT-файла -->
<xsl:stylesheet version = "1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!-- Шаблон, применяемый для трансформации корневого XML-элемента -->
<xsl:template match="/">
<!-- Выводим базовые HTML-теги -->
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <title>Wallpapers</title>
    <!--<meta firstName="keywords" content="" />
    <meta firstName="description" content="" />
-->

</head>

<body>

    <div class="wrapper">

        <header class="header">
            <div class="main">
                <div class="container"></div>
                <a href="index.html" class="logo"><img src="resources/img/logo2.png" style="width: 40px"/></a>
                <nav>
                    <ul>
                        <li><a href="index.html">Главная</a></li>
                        <li><a href="category.html">Категории</a></li>
                        <li onmousemove="changeColor()"><a href=""><div id="button1">О нас</div></a></li>
                        <li><a href="">Контакты</a></li>
                    </ul>

                </nav>
            </div>
        </header><!-- .header-->
        <main class="main-container">
        <table>
            <tr> <td colspan="3" style="font-weight:bold">Phones:</td> </tr>

            <xsl:for-each select="//contact">
                <xsl:sort order="descending" select="value"/>

                <xsl:if test="@type='phone'">
                    <tr>
                        <td><img src="{image}" width="25"/></td>
                        <td><xsl:value-of select="name"></xsl:value-of></td>
                        <td><xsl:value-of select="value"></xsl:value-of></td>
                    </tr>
                </xsl:if>
            </xsl:for-each>

            <tr> <td colspan="3" style="font-weight:bold">Emails:</td> </tr>

            <xsl:for-each select="//contact">
                <xsl:sort order="descending" select="value"/>

                <xsl:if test="@type='email'">
                    <tr>
                        <td><img src="{image}" width="25"/></td>
                        <td><xsl:value-of select="name"></xsl:value-of></td>
                        <td><xsl:value-of select="value"></xsl:value-of></td>
                    </tr>
                </xsl:if>
            </xsl:for-each>

            <tr> <td colspan="3" style="font-weight:bold">Offices:</td> </tr>

            <xsl:for-each select="//contact">
                <xsl:sort order="descending" select="value"/>

                <xsl:if test="@type='address'">
                    <tr>
                        <td><img src="{image}" width="25"/></td>
                        <td><xsl:value-of select="name"></xsl:value-of></td>
                        <td><xsl:value-of select="value"></xsl:value-of></td>
                    </tr>
                </xsl:if>
            </xsl:for-each>

        </table>
        </main><!-- .content -->

    </div><!-- .wrapper -->

    <footer class="footer"></footer><!-- .footer -->

    <!--<link href="assets/css/reset.css" rel="stylesheet">-->
    <link href="resources/css/style.css" rel="stylesheet"/>
    <script src="resources/js/script.js"></script>
</body>
</html>
        </xsl:template>
        </xsl:stylesheet>