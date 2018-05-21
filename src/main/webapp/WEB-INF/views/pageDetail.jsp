<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:genericpage>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">

                <a href="/admin/" class="btn btn-info"><i class="fas fa-angle-double-left"></i>  Tüm Sayfalar</a>
                <br>

                <h3 class="text-center koyu_mavi">"<strong>${page.pageUrl}</strong>" adresine yapılan istekler</h3>
                <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        Sıralama
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li><a href="?sort=newest">Yeniden Eskiye</a></li>
                        <li><a href="?sort=oldest">Eskiden Yeniye</a></li>
                    </ul>
                </div>

                <br>

                <table class="table table-striped">
                    <tr class="koyu_mavi">
                        <td><strong>IP Address</strong></td>
                        <td><strong>User-Agent</strong></td>
                        <td><strong>Tarih</strong></td>
                    </tr>
                    <c:forEach items="${pageLogs}" var="log">
                        <tr>
                            <td>${log.ipAddress}</td>
                            <td>${log.agent}</td>
                            <td>${log.timestamp}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br/>

            </div>
        </div>
    </div>
</t:genericpage>