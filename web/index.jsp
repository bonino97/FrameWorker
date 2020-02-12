<%-- 
    Document   : index
    Created on : 12/11/2019, 20:27:38
    Author     : bonii
--%>

<%@page import="Models.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSession = request.getSession();
    Session userSession = (Session)objSession.getAttribute("session"); 
    String error = (String)objSession.getAttribute("error");     
    
    if(userSession != null)
    {
        response.sendRedirect("Vistas/dashboard.jsp");
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="Materialize/css/materialize.min.css"  media="screen,projection"/>
        
        <script src="Vistas/assets/js/main.js"></script>
        
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>FrameWorker</title>
    </head>
    <body>
        <div class="card horizontal">
          <div class="container">
           <h3>Iniciar Sesion</h3>
            <div class="row">   
              <form action="iniciar" method="post" class="col s12" id="formInicio">
                <div class="row">
                  <div class="input-field col s6">
                    <i class="material-icons prefix">account_circle</i>
                    <input required id="icon_prefix" type="text" class="validate" name="userName" id="idUsuario">
                    <label for="icon_prefix">Usuario</label>
                  </div>
                </div>
                <div class="row">
                  <div class="input-field col s6">
                    <i class="material-icons prefix">https</i>
                    <input required id="icon_password" type="password" class="validate" name="password" id="idPassword">
                    <label for="icon_password">Contraseña</label>
                  </div>
                </div>
                <div class="row">
                  <div class="input-field col s6">
                    <input  type="submit" value="Iniciar Sesion" class="waves-effect waves-light btn" id="btnIniciar"/>
                  </div>
                </div>
                <%
                    objSession.removeAttribute("error");     
                    if(error != null)  {
                %> 
                <div class="row">
                    <div id="card-alert" class="card red col s6">
                      <div class="card-content white-text">
                        <p><%= error %></p>
                      </div>
                    </div>
                </div>
                <%
                    }
                %>
                </br> 
                <div class="row">
                  <p>No tienes una cuenta? &nbsp;&nbsp;<a href="Vistas/register.jsp"><b>Registrate</b></a></p>
                </div>
              </form>
            </div>
          </div>
        </div>
        
      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <script type="text/javascript" src="Materialize/js/materialize.min.js"></script>
    </body>
</html>
