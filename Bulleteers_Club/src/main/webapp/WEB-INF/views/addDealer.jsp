<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Custom CSS -->
    <link href="resources/assets/css/ride.css"  rel="stylesheet">
      
    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

 <div class="brand">Bulleteers Club</div>
    <div class="address-bar">125 Park Drive | Boston, MA 02215 </div>

    

    <div class="container">

       

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                <h3 class="brand-name text-center">Register yourself as the Dealer</h3>
                        <h5 class="intro-text text-center">Please fill out each section completely</h5>
                </div>        
            </div>           
        </div>    

        <form:form class="form-login" method="POST" action="addDealerDetails" commandname="dealer">
        <div class="row">
            <div class="greenbox">
                    <div class="col-12-lg">

                        
                            <h4 class="intro-text text-left">
                                    <strong>Check UserName Availability!</strong>
                                    <font color="red"><c:out value="${requestScope.error}"/></font>
                                </h4>

                              <div class="form-group">
                                    <label for="username">Username:</label>
                                    <input type="text" class="form-control" name="username" id="usertxt" placeholder="Enter Username" required>
                                    <span class="alert">Username Already Exists!</span>
                                    <span class="glyphicon glyphicon-ok" id="tick"></span>
                                    <span id="empty">Username can't be Empty!</span>
                                </div>
                                <div class="form-group">
                                    <label for="pwd">Password:</label>
                                    <input type="password" class="form-control" id="pwd" name="password" placeholder="Enter Password" required>
                                    <font color="red"><form:errors name="password"/></font>
                                </div> 



                        

                    </div>    
            </div>    
         
        </div>

        <div class ="row">
            <div class ="box">
                <div class ="col-lg-12">
                    <h4 class="intro-text text-left">
                                    <strong>Dealership Information!</strong>
                                </h4>
                                <div class="form-group">
                                    <label for ="firstName">First Name</label>
                                    <input type="text" class="form-control" name="firstName" id="nameTxt" placeholder="Enter Name" required>
                                    <font color="red"><form:errors path="firstName"/></font>
                                </div>
                                <div class="form-group">
                                    <label for ="lastName">Last Name</label>
                                    <input type="text" class="form-control" name="lastName"id="lastNameTxt" placeholder="Enter Last Name" required>
                                </div>
                                <div class="form-group">
                                    <label for ="gender">Gender</label>
                                </br>
                                   <label class="radio-inline"><input type="radio" name="gender" value="Male">Male</label>
                                    <label class="radio-inline"><input type="radio" name="gender" value="Female">Female</label>
                                </div>
 

                                <div class="form-group">
                                    <label for ="email">Enter Email</label>
									<input type="email" name="email" class="form-control" id="emailTxt" placeholder="Enter Email" required>
                                </div>
								
								 <div class="form-group">
                                    <label for ="dateofbirth">Date of Birth :</label>
                                    <input id="dob" class="form-control" name="dob" type="date" required>
                                </div>
								
						
						
				
                                
                                 <div class="form-group">
                                    <label for ="firstName">City</label>
                                    <input type="text" class="form-control" list="citylist"id="citytxt" placeholder="Enter City" required>
                                    <datalist id="citylist">
                                        <option></option>
                                    </datalist>
                                </div>    

                            

								
								<div class="form-group">
                                    <label for ="country">Country</label>
                                    <input type="text" class="form-control" list="countrylist" name="list" id="list" placeholder="Enter Country" required>
                                    <datalist id="countrylist">
                                        <option></option>
                                    </datalist>
                                </div>
								
                                <button type="btn btn-success
                              " class="btn btn-success" type="submit">Submit </button>
                </div>    
            </div>    
        </div> 
	</form:form>     

          <div class="modal fade bs-example-modal-sm" tabindex="-1"   role= "dialog" aria-labelledby="mySmallModalLabel">
            <div class="modal-dialog modal-sm">
            <div class="modal-content">
              <h5 class="intro-text text-center">Welcome To The Club</h5>
              <hr>
              <div id="nextpage">
              <a href="index.html" class="btn btn-primary" role="button">Enter</a>
            </div>
            </div>
            </div>
          </div>
       

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Bulleteers Club</p>
                </div>
            </div>
        </div>
    </footer>

<script type="text/javascript" src="resources/assets/js/source/backstretch.js"></script>
   <script type="text/javascript">
   $.backstretch("resources/assets/images/bg1.jpg");
   </script>
   <script type="text/javascript" src="resources/assets/js/build/validateusername.js"></script>
   <script type="text/javascript" src="resources/assets/js/build/cities.js"></script>
   <script type="text/javascript" src="resources/assets/js/build/country.js"></script>
   <script type="text/javascript" src="resources/assets/js/source/bootstrap-notify.js"></script>
<script type="text/javascript" src="resources/assets/js/source/bootstrap-notify.min.js"></script>
</body>
</html>