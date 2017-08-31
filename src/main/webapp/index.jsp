<%@page import="com.sv.udb.controladores.UsuariosCtrl"%>
<%@page import="com.sv.udb.modelos.Conversaciones"%>
<%@page import="com.sv.udb.modelos.Usuarios"%>
<%@page import="com.sv.udb.modelos.Respuestas"%>
<%@page import="com.sv.udb.controladores.RespCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Refresh" content="10;index.jsp">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/lib/css/estilo.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <!--script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/js/chat.js"></script-->
        <title>Chat genialongo :3</title>
    </head>
    <%
        session = request.getSession(true);
        Usuarios usuaActu = (Usuarios) session.getAttribute("usuaActu");
        Conversaciones convActu = (Conversaciones) session.getAttribute("convActu");
        if (usuaActu == null)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            if (convActu == null)
            {
                response.sendRedirect("menu.jsp");
            }
        }
    %> 
    <body>
        <li><a href="menu.jsp"><h2>Menu</h2></a></li>
        </ul>  
        <div class="chat_window">
            <div class="top_menu">
                <div class="buttons">
                    <div class="button close"></div>
                    <div class="button minimize"></div>
                    <div class="button maximize"></div>
                </div>
                <%
                    if (1==1)
                    {
                        Usuarios usuaConvResp = new Usuarios();
                        if (!convActu.getUsuaUno().equals(usuaActu))
                        {
                            usuaConvResp = new UsuariosCtrl().cons(convActu.getUsuaUno().getCodiUsua());
                        }
                        else if (!convActu.getUsuaDos().equals(usuaActu))
                        {
                            usuaConvResp = new UsuariosCtrl().cons(convActu.getUsuaDos().getCodiUsua());
                        }
                    
                %>
                <div class="title">
                    <%=usuaConvResp.getNombUsua()%>
                </div>
                <%
                    }
                %>
            </div>
            <ul class="messages">
                <%
                    for (Respuestas temp : new RespCtrl().cons(convActu, usuaActu.getCodiUsua()))
                    {
                        String prop = temp.getCodiUsuaResp().equals(usuaActu) ? "right" : "left";
                %>
                <li class="message <%=prop%> appeared">
                    <div class="avatar"></div>
                    <div class="text_wrapper">
                        <div class="text"><%=temp.getMensResp()%></div>
                    </div>
                </li>    
                <%
                    }
                %>
            </ul>
            <form method="POST" action="RespServ">
                <div class="bottom_wrapper clearfix">
                    <div class="message_input_wrapper">
                        <input type="text" id="resp" name="resp" class="message_input" placeholder="Type your message here..." />
                    </div>
                    <div class="send_message">
                        <input type="submit" class="btn orange-circle-button" name="RespBton" value="Enviar"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="message_template">
            <li class="message">
                <div class="avatar"></div>
                <div class="text_wrapper">
                    <div class="text"></div>
                </div>
            </li>
        </div>
    </body>
    <script>
        
    </script>
</html>
