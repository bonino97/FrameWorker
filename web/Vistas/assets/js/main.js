/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.addEventListener('load', function(){
    document.getElementById('btnIniciar').addEventListener('click',function(){
       var usuario = document.getElementById('idUsuario').value;
       var password = document.getElementById('idPassword').value;
       
       var flag = false;
       
       if(usuario.length > 0 && contraseña.length > 0){
           flag = true;
       }
       if(bandera){
           document.getElementById('formInicio').submit();
       }
       
    });
});
