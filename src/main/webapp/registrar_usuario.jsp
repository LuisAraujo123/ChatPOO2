<%-- 
    Document   : registrar_usuario
    Created on : 08-28-2017, 10:02:31 PM
    Author     : DanielWilfredo
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
        <!--script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/js/chat.js"></script-->
        <title>Chat genialongo :3</title>
    </head>
    <body>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br><form method="POST" action="UsuaServ">
              <h1>${mensAler}</h1>
            
               <div class="container">
        <div class="row centered-form">
              <div class="panel panel-default">
        		<div class="panel-heading">
                            <center><h1>Registrar Usuario</h1></center> 
			 			</div>
			 			<div class="panel-body">
			    		<form role="form">
			    					<div class="form-group">
			                <input type="text" name="nomb" id="nomb" class="form-control input-sm" placeholder="Nombres">
			    					</div>

			    			<div class="form-group">
			    				<input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address">
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="password" name="cont" id="cont" class="form-control input-sm" placeholder="Password">
			    					</div>
			    				</div>
                                                            <div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="password" name="cont2" id="cont2" class="form-control input-sm" placeholder="Confirm Password">
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<input type="submit" name="TipoBton" value="Registrar" class="btn btn-info btn-block">
			    		
			    					    	</div>
	    		</div>
       	
    	
    	</div>
    </div>
            
        </form>
     
    </body>
</html>
