<%-- 
    Document   : prueba
    Created on : Aug 30, 2017, 6:47:34 PM
    Author     : bernardo
--%>

<%@page import="com.sv.udb.modelos.Conversaciones"%>
<%@page import="com.sv.udb.modelos.Usuarios"%>
<%@page import="com.sv.udb.controladores.RespCtrl"%>
<%@page import="com.sv.udb.modelos.Respuestas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session = request.getSession(true);
    Usuarios usuaActu = (Usuarios) session.getAttribute("usuaActu");
    Conversaciones convActu = (Conversaciones) session.getAttribute("convActu");
    for (Respuestas temp : new RespCtrl().cons(convActu, usuaActu.getCodiUsua())) {
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