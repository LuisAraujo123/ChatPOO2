<%-- 
    Document   : login
    Created on : 08-28-2017, 09:53:56 PM
    Author     : leyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/lib/css/estilo.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${mensAler}</h1>
    <div class="container">
        <div class="row">
            <form method="POST" action="LoginServ">
                <div class="col-md-offset-4 col-md-5">
                    <div class="form-login">
                    <h4></h4>
                    <input type="text" class="form-control input-sm chat-input" id="user" name="user" placeholder="Usuario" />
                    </br>
                    <input type="password" class="form-control input-sm chat-input" id="cont" name="cont"  placeholder="Contraseña" />
                    </br>
                    <div class="wrapper">
                    <span class="group-btn">     
                         <input type="submit" name="TipoBton" value="Ingresar" class="btn btn-sm btn-success" />
                    </span>
                    </div>
                    </div>

                </div>  
            </form>
        </div>
    </div>
    </body>
</html>
