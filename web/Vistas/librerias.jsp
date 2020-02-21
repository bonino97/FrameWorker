<%-- 
    Document   : lenguajes
    Created on : 13/11/2019, 02:14:16
    Author     : bonii
--%>

<%@page import="Models.Session"%>
<%@page import="Controllers.LibraryController"%>
<%@page import="Models.Library"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objSession = request.getSession();
    Session userSession = (Session)objSession.getAttribute("session"); 
    String error = (String)objSession.getAttribute("error"); 
    
    if(userSession == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
    
    ArrayList<Library> Libraries = LibraryController.GetAll();
    
    if(Libraries == null)
    {
        error = "No pudimos recuperar las librerias.";
    }
%>

<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    FrameWorker
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="assets/css/material-dashboard.css?v=2.1.1" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="azure" data-background-color="white" data-image="assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="#" class="simple-text logo-normal">
          FRAMEWORKER
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <% if(userSession.getLogedUser().isIsSuperuser()) {%>
          <li class="nav-item ">
            <a class="nav-link" href="./users.jsp">
              <i class="material-icons">group</i>
              <p>Usuarios</p>
            </a>
          </li>
          <%}%>
          <li class="nav-item ">
            <a class="nav-link" href="./lenguajes.jsp">
              <i class="material-icons">content_paste</i>
              <p>Lenguajes</p>
            </a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="./librerias.jsp">
              <i class="material-icons">menu_book</i>
              <p>Librerias</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="./proyectos.jsp">
              <i class="material-icons">library_books</i>
              <p>Proyectos</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="./dashboard.jsp">Dashboard</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="./dashboard.jsp">
                  <i class="material-icons">dashboard</i>
                  <p class="d-lg-none d-md-block">
                    Stats
                  </p>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" href="#" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                  <a class="dropdown-item" href="./update-user.jsp">Perfil</a>
                  <a class="dropdown-item" href="./update-user.jsp">Ajustes</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="../logout">Cerrar Sesion</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="container">
            <% if(userSession.getLogedUser().isIsSuperuser()) {%>
            <a href="/FrameWorker/Vistas/create-library.jsp" class="btn btn-info pull-right">Agregar libreria</a>
            <%}%>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Lenguaje</th>
                        <% if(userSession.getLogedUser().isIsSuperuser()) {%>
                        <th class="text-right">Acciones</th>
                        <%}%>
                    </tr>
                </thead>
                <% if(Libraries != null) {%>
                 <%  for(int i = 0; i < Libraries.size(); i++) {
                        Library Lib = (Library)Libraries.get(i);
               %>
                <tbody>
                    <tr>
                        <td><%= Lib.getName() %></td>
                        <td><%= Lib.getLenguage().getName() %></td>
                        <% if(userSession.getLogedUser().isIsSuperuser()) {%>
                        <td class="td-actions text-right">
                            <a href="./update-library.jsp?id=<%= Lib.getId()%>" rel="tooltip" class="btn btn-success">
                                <i class="material-icons">edit</i>
                            </a>
                             <form style="display: inline-block" action="../delete-library" method="post">
                                <input type="hidden" name="id" value="<%= Lib.getId()%>" />
                                <button type="submit" rel="tooltip" class="btn btn-danger">
                                   <i class="material-icons">close</i>
                               </button>
                             </form>
                        </td>
                        <%}%>
                    </tr>
                </tbody> 
                <% } %>
                <% } %>
            </table>
            <%  objSession.removeAttribute("error");     
                if(error != null && !error.isEmpty()) 
            {%>
              <div class="alert alert-danger" style="margin-right: 10px; margin-left: 10px" role="alert">
                 <%=error %>
              </div>
            <%}%> 
        </div>
      </div>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="assets/js/core/jquery.min.js"></script>
  <script src="assets/js/core/popper.min.js"></script>
  <script src="assets/js/core/bootstrap-material-design.min.js"></script>
  <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Plugin for the momentJs  -->
  <script src="assets/js/plugins/moment.min.js"></script>
  <!--  Plugin for Sweet Alert -->
  <script src="assets/js/plugins/sweetalert2.js"></script>
  <!-- Forms Validations Plugin -->
  <script src="assets/js/plugins/jquery.validate.min.js"></script>
  <!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="assets/js/plugins/jquery.bootstrap-wizard.js"></script>
  <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="assets/js/plugins/bootstrap-selectpicker.js"></script>
  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
  <script src="assets/js/plugins/jquery.dataTables.min.js"></script>
  <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="assets/js/plugins/bootstrap-tagsinput.js"></script>
  <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
  <script src="assets/js/plugins/jasny-bootstrap.min.js"></script>
  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="assets/js/plugins/fullcalendar.min.js"></script>
  <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
  <script src="assets/js/plugins/jquery-jvectormap.js"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="assets/js/plugins/nouislider.min.js"></script>
  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <!-- Library for adding dinamically elements -->
  <script src="assets/js/plugins/arrive.min.js"></script>
  <!-- Chartist JS -->
  <script src="assets/js/plugins/chartist.min.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="assets/js/material-dashboard.js?v=2.1.1" type="text/javascript"></script>
  <script>
    $(document).ready(function() {
      // Javascript method's body can be found in assets/js/demos.js
      md.initDashboardPageCharts();

    });
  </script>
</body>

</html>

