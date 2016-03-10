<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .error {
        color: red;
    }
</style>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Inventory | Log in</title>
        <jsp:include page="../partials/head-imports.jsp" />

        <!-- iCheck -->
        <link rel="stylesheet" href="<c:url value="/resources/plugins/iCheck/square/blue.css"/>">

    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <b>Flow</b>etc
            </div><!-- /.login-logo -->
            <div class="login-box-body">                
                <c:choose>
                    <c:when test="${loginBean.getValidity() == 'INCORRECT_PASSWORD'}">
                        <p class="login-box-msg error">Incorrect Password</p>
                    </c:when>
                    <c:when test="${loginBean.getValidity() == 'UNREGISTERED'}">
                        <p class="login-box-msg error">Unregistered Email</p>
                    </c:when>
                    <c:otherwise>
                        <p class="login-box-msg">Sign in to start your session</p>
                    </c:otherwise>
                </c:choose>

                <form:form id="loginForm" method="post" action="login" modelAttribute="loginBean">
                    <div class="form-group has-feedback">
                        <form:input id="email" name="email" path="email" type='email' class='form-control' placeholder='Email'/>
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <form:input id="password" name="password" path="password" type='password' class='form-control' placeholder='Password' />                        
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox"> Remember Me
                                </label>
                            </div>
                        </div><!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                        </div><!-- /.col -->
                    </div>
                </form:form>

                <a href="#">I forgot my password</a><br>                

            </div><!-- /.login-box-body -->
        </div><!-- /.login-box -->

        <jsp:include page="../partials/body-imports.jsp" />

        <script src="<c:url value="/resources/plugins/iCheck/icheck.min.js" />"></script>

        <script>
            (function () {

                $(document).ready(function () {
                    $('input').iCheck({
                        checkboxClass: 'icheckbox_square-blue',
                        radioClass: 'iradio_square-blue',
                        increaseArea: '20%' // optional
                    });
                });

            })();
        </script>
    </body>
</html>
