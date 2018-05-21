<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h3>Giriş Yap</h3>
                <hr>

                <c:if test="${not empty error}">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>Hata!</strong> ${error}
                    </div>
                </c:if>

                <c:if test="${not empty msg}">
                    <div class="alert alert-info alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        ${msg}
                    </div>
                </c:if>

                <form action="<c:url value='/login' />" method='POST'>
                    <div class="form-group">
                        <label for="username">Kullanıcı Adı</label>
                        <input type="text" name="username" class="form-control" id="username">
                    </div>
                    <div class="form-group">
                        <label for="password">Parola</label>
                        <input type="password" name="password" class="form-control" id="password">
                    </div>

                    <input type="submit" name="submit" class="btn btn-primary" value="Giriş Yap">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

            </div>
        </div>
    </div>
</t:genericpage>