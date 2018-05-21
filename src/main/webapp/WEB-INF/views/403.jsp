<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>HTTP Status 403 - Geçersiz Erişim</h1>

	<c:choose>
		<c:when test="${empty username}">
			<h2>Bu sayfaya erişim izniniz yok!</h2>
		</c:when>
		<c:otherwise>
			<h2>Username : ${username} <br/>Bu sayfaya erişim izniniz yok!</h2>
		</c:otherwise>
	</c:choose>

</body>
</html>