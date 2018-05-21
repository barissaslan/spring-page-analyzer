<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:genericpage>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">

                <h2>Bütün Sayfalar</h2>
                <hr>
                <table class="table table-striped">
                    <tr class="koyu_mavi">
                        <td><strong>Sayfa</strong></td>
                        <td><strong>Hit Sayısı</strong> </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach items="${pages}" var="page">
                        <tr>
                            <td>${page.pageUrl}</td>
                            <td>${fn:length(page.pageLogs)}</td>
                            <td><a href="/admin/page/${page.id}">İncele</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <br/>

            </div>
        </div>
    </div>
</t:genericpage>