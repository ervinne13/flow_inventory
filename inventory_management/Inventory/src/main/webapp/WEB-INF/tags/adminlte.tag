<%@tag description="Admin LTE Page Template Tag" pageEncoding="UTF-8"%>
<%@attribute name="bodyImports" fragment="true" %>
<%@attribute name="pageTitle" required="true" fragment="true" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>
            <jsp:invoke fragment="pageTitle"/>
        </title>
        <jsp:include page="../jsp/partials/head-imports.jsp"/>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">
            <!--Header-->
            <jsp:include page="../jsp/partials/main-header.jsp"/>

            <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="../jsp/partials/side-bar.jsp"/>

            <jsp:doBody/>

            <jsp:include page="../jsp/partials/footer.jsp" />

            <!-- Control Sidebar -->
            <jsp:include page="../jsp/partials/control-side-bar.jsp" />
        </div><!-- ./wrapper -->

        <jsp:include page="../jsp/partials/body-imports.jsp"/>
        
        <jsp:invoke fragment="bodyImports"/>
    </body>
</html>
