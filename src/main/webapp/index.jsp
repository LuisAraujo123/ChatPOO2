<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/lib/css/estilo.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/js/chat.js"></script>
        <title>Chat genialongo :3</title>
    </head>
    <body>
        <div class="chat_window">
            <div class="top_menu">
                <div class="buttons">
                    <div class="button close"></div>
                    <div class="button minimize"></div>
                    <div class="button maximize"></div>
                </div>
                <div class="title">Chat</div>
            </div>
            <ul class="messages"></ul>
            <div class="bottom_wrapper clearfix">
                <div class="message_input_wrapper">
                    <input class="message_input" placeholder="Type your message here..." />
                </div><div class="send_message">
                    <div class="icon"></div>
                    <div class="text">Send</div>
                </div>
            </div>
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
</html>
