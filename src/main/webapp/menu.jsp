<%@page import="java.util.List"%>
<%@page import="com.sv.udb.controladores.UsuariosCtrl"%>
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
        <title>Chat genialongo :3</title>
    </head>
    <%
        session = request.getSession(true);
        Usuarios usuaActu = (Usuarios) session.getAttribute("usuaActu");
        if (usuaActu == null)
        {
            response.sendRedirect("login.jsp");
        }
    %>
    <body>
        <li><a href="login.jsp"><h3>Salir</h3></a></li>
        <div class="container">      
            <div class="col-sm-12 chat_sidebar">
                <div class="row">
                    <div id="custom-search-input">
                        <div class="input-group col-md-12">
                            <input type="text" class="  search-query form-control" placeholder="Buscar conversación" />
                            <button class="btn btn-danger" type="button">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </div>
                    </div>
                    <form method="POST" action="ConvServ">
                        <h4>Conversaciones${mensAler}</h4>
                        <div class="member_list">
                            <ul class="list-unstyled">
                                <%
                                    UsuariosCtrl usuaCtrl = new UsuariosCtrl();
                                    List<Conversaciones> conv = new ConvCtrl().cons();
                                    List<Usuarios> usuaList = usuaCtrl.cons();
                                    usuaList.remove(usuaActu);
                                    for (Conversaciones temp : conv) {
                                        if (usuaActu.equals(temp.getUsuaUno()) || usuaActu.equals(temp.getUsuaDos())) {
                                            if (usuaActu.equals(temp.getUsuaUno()))
                                            {
                                                usuaList.remove(temp.getUsuaDos());
                                            }
                                            else if (usuaActu.equals(temp.getUsuaDos()))
                                            {
                                                usuaList.remove(temp.getUsuaUno());
                                            }
                                %>
                                <li class="left clearfix">                    
                                    <div class="chat-body clearfix">
                                        <div class="header_sec">
                                            <input type="submit" class="btn orange-circle-button" name="ConvBton" value="<%=temp.getCodiConv()%>"/>
                                            <strong class="primary-font"><%=temp.getUsuaUno().getNombUsua()%>, <%=temp.getUsuaDos().getNombUsua()%></strong> <strong class="pull-right">
                                                <%=temp.getTempConv()%></strong>
                                        </div>
                                    </div>
                                </li>  
                                <%
                                        }
                                    }
                                %>
                            </ul>
                        </div>
                        <h4>Usuarios sin conversar</h4>
                        <div class="member_list">
                            <ul class="list-unstyled">
                                <%
                                    for (Usuarios temp : usuaList)
                                    {
                                %>
                                <li class="left clearfix">                    
                                    <div class="chat-body clearfix">
                                        <div class="header_sec">
                                            <input type="submit" class="btn orange-circle-button" name="InicBton" value="<%=temp.getCodiUsua()%>"/>
                                            <strong class="primary-font"><%=temp.getNombUsua()%>, <%=temp.getMailUsua()%></strong> <strong class="pull-right">
                                                Fecha no disponible porque es ahora :)</strong>
                                        </div>
                                    </div>
                                </li>  
                                <%
                                    }
                                %>
                            </ul>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
