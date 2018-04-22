<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

<script

  src="https://code.jquery.com/jquery-3.2.1.min.js"

  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="

  crossorigin="anonymous"></script>

</head>

 

<body>

<form name ="myform" action="/SpringMVCCrud/loginprocess" method="POST">

        Enter username :<input type="text" name="Username" id="Username" required> <br>

        Enter password :<input type="password" name="Password"  id="Password" required><br>

        

      

            

              <input type="submit" value="login">

             

</form>


 <script>

       $(document).ready(function(e) {

 

              $("#form_click").off('click').on('click',function(e) {

                     debugger;

                     e.stopPropagation();

                     registerViaAjax().done(function(){

                           alert("working");

                     });

 

              });

 

       });

      

       function registerViaAjax() {

             

              var userModel = {};

              userModel["Username"] = $("#Username").val();

              userModel["Password"] = $("#Password").val();

             
              /* var flag = false;

              var str ;

              var regex = '';

              if(regex.test($("#phone").val()))

              if($("#phone").val().length === 0)

                     flag = true;

                     return false;

              } */

 

             

                    

              }

                 return $.ajax({

                     type : "POST",

                     contentType : "application/json",

                     url : "http://localhost:8080/SpringMVCCrud/login",

                     data : JSON.stringify("userModel"),

                     success : function(res) {

                           console.log("SUCCESS: ", res);

                           if(res){

                                  window.location.href="http://localhost:8080/SpringMVCCrud/welcome";

                           }else

                                  {

                        	   window.location.href="http://localhost:8080/SpringMVCCrud/login";

                                  }

                                 

                     },

                     error : function(e) {

                           console.log("ERROR: ", e);

                     }

                    

              });

 

      

       </script>

 

 

 

 

 

</body>

</html>