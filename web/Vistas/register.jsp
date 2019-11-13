<%-- 
    Document   : register
    Created on : 12/11/2019, 21:03:43
    Author     : bonii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="../Materialize/css/materialize.min.css"  media="screen,projection"/>
      <title>FrameWorker</title>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
        <div class="container">
        <h3>Formulario de Registro</h3>
          <div class="row">
            <form action="../registrar-usuario" method="post" class="col s12">
              <div class="row">
                <div class="input-field col s6">
                  <input name ="name" id="first_name" type="text" class="validate">
                  <label for="first_name">Nombre</label>
                </div>
                <div class="input-field col s6">
                  <input name ="surname" id="last_name" type="text" class="validate">
                  <label for="last_name">Apellido</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input name ="username" id="user_name" type="text" class="validate">
                  <label for="user_name">Usuario</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input name ="password" id="password" type="password" class="validate">
                  <label for="password">Contraseña</label>
                </div>
              </div>
              <div class="row">
                <div class="input-field col s12">
                  <input name ="email" id="email" type="email" class="validate">
                  <label for="email">Email</label>
                </div>
              </div>
              <div class="row">
                <input type="submit" value="Registrate" class="waves-effect waves-light btn">
                <a type="submit" class="waves-effect waves-light btn right" href="../index.jsp">Cancelar</a>
              </div>
            </form>
          </div>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="../Materialize/js/materialize.min.js"></script>
    </body>
  </html>