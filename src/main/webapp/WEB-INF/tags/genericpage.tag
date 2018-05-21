<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Web Page Analyzer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">
    <style>
        .mavi {
            color: #428bca !important;
        }

        .koyu_mavi {
            color: #428bca !important;
            font-weight: bold !important;
        }
    </style>
</head>
<body>

<!-- Navbar Start -->
<nav class="navbar navbar-default" role="banner">
    <div class="container">

        <div class="navbar-header">

            <!-- Telefon ekranları için menü butonu -->
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <!-- İsim Soyisim veya Marka İsmi -->
            <a href="/" class="navbar-brand koyu_mavi">Web Page Analyzer</a>
        </div>

        <nav class="collapse navbar-collapse" role="navigation">

            <!-- Arama Çubuğu -->
            <form class="navbar-form navbar-left" role="search" method="GET" action="">
                <div class="input-group">
                    <input class="form-control" type="text" name="q" placeholder="Search" value="">
                    <span class="input-group-btn">
                                <input class="btn btn-default mavi" type="submit" value="Ara">
                            </span>
                </div>
            </form>

            <!-- Temel Sayfalar -->
            <ul class="nav navbar-nav navbar-right">
                <li><a class="mavi" href="/">Anasayfa</a></li>
                <li><a class="mavi" href="/blog">Blog</a></li>
                <li><a class="mavi" href="/hakkinda">Hakkında</a></li>
                <li><a class="mavi" href="/iletisim">İletişim</a></li>
                <sec:authorize var="loggedIn" access="isAuthenticated()"/>
                <c:choose>
                    <c:when test="${loggedIn}">
                        <li>
                            <script>
                                function formSubmit() {
                                    document.getElementById("logoutForm").submit();
                                }
                            </script>

                            <a class="mavi" href="javascript:formSubmit()">Çıkış Yap</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>

        </nav>

    </div>
</nav>

<form action="<c:url value="/logout" />" method="POST" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<div id="body">
    <jsp:doBody/>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>