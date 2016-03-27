<%@tag description="Admin LTE Page Template Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="bodyImports" fragment="true" %>
<%@attribute name="headImports" fragment="true" %>
<%@attribute name="pageTitle" required="true" fragment="true" %>
<%@attribute name="skin" required="true" fragment="true" %>

<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>
            <jsp:invoke fragment="pageTitle"/>
        </title>

        <meta name="base-url" content="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />

        <jsp:include page="/WEB-INF/jsp/partials/head-imports.jsp"/>

        <jsp:invoke fragment="headImports"/>
    </head>
    <body class="hold-transition <jsp:invoke fragment="skin"/> sidebar-mini">
        <div class="wrapper">
            <!--Header-->
            <jsp:include page="/WEB-INF/jsp/partials/main-header.jsp"/>

            <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="/WEB-INF/jsp/partials/side-bar.jsp"/>

            <jsp:doBody/>

            <jsp:include page="/WEB-INF/jsp/partials/footer.jsp" />

            <!-- Control Sidebar -->
            <jsp:include page="/WEB-INF/jsp/partials/control-side-bar.jsp" />
        </div><!-- ./wrapper -->

        <jsp:include page="/WEB-INF/jsp/partials/body-imports.jsp"/>

        <jsp:invoke fragment="bodyImports"/>
    </body>
</html>
