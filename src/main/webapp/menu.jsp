<%@page import="com.sv.udb.controladores.ConvCtrl"%>
<%@page import="com.sv.udb.modelos.Conversaciones"%>
<%@page import="com.sv.udb.modelos.Usuarios"%>
<%-- 
    Document   : menu
    Created on : 08-28-2017, 10:09:30 PM
    Author     : Jose Lira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/lib/css/estilo2.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <!--script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/js/chat.js"></script-->
        <title>Chat genialongo :3</title>
    </head>
    <%
        session = request.getSession(true);
        Object usuaActu = session.getAttribute("usuaActu");
        if (usuaActu == null)
        {
            response.sendRedirect("login.jsp");
        }
    %>
    <body>
        <div class="container">      
         <div class="col-sm-12 chat_sidebar">
    	 <div class="row">
        <div id="custom-search-input">
               <div class="input-group col-md-12">
                  <input type="text" class="  search-query form-control" placeholder="Conversation" />
                  <button class="btn btn-danger" type="button">
                  <span class=" glyphicon glyphicon-search"></span>
                  </button>
               </div>
            </div>
             
              <div class="member_list">
               <ul class="list-unstyled">
            <%
                for (Conversaciones temp : new ConvCtrl().cons()) 
                 {
            %>
                  <li class="left clearfix">                    
                     <div class="chat-body clearfix">
                        <div class="header_sec">
                           <strong class="primary-font"><%=temp.getUsuaUno().getNombUsua()%> ,<%=temp.getUsuaDos().getNombUsua()%></strong> <strong class="pull-right">
                           <%=temp.getTempConv()     %></strong>
                     </div>
                        
                     </div>
                  </li>
            <%                            
                 }
            %>
            
             
         </div>
         </div>
      
        </div>
    </body>
</html>
