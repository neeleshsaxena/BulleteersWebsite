<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Custom CSS -->
    <link href="resources/assets/css/ride.css"  rel="stylesheet">
    
    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.1/animate.min.css">
</head>
<body>


<div class="brand">${club.clubName } Club</div>
    <div class="address-bar">125 Park Drive | Boston, MA 02215 </div>
    
    
    <!-- toolbar will have home, Rides-Past/Present, Member Profiles in the club, Accessories  -->    
    
    <!-- Navigation -->
    
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">${club.clubName } Club</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <!--  -------------------------------------------------------------------------------- -->
            <!--  add name of the member here -->
            <!--  -------------------------------------------------------------------------------- -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <i class="fa fa-motorcycle intro-text" > Welcome ${member.firstName }</i>
                <ul class="nav navbar-nav">
                   
                    <li>
                        <a href="redirectToHome">Home</a>
                    </li>
                    
                    <li>
                        <a href="displayAccessories">Display Accessories</a>
                    </li>
             <!--     ********************* -->    
             <li class="dropdown danger">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i id ="notCount" class="fa fa-star-half-o "></i> ${count }</a>
                            <ul class="dropdown-menu danger  animated fadeInDown">
                                <li class="title">
                                
                                <!--  **********insert the unseen mesg count************* -->
                                    Notification <span class="badge pull-right">${count }</span>
                                </li>
                                <li>
                                    <ul class="list-group notifications">
                                        <c:forEach var="message" items="${notification }">
                                        <li class="list-group-item message">
                                              <c:out value="${message.text }"></c:out></br>
                                              <c:out value="From ${message.fromPerson.firstName }"></c:out>
                                          </li>
                                        
                                        </c:forEach>
                                    </ul>
                                </li>
                            </ul>
                        </li>
             
              <!--     ********************* -->   
              <!--  *****************log out button********************************* -->
              
              <li><a class="logout" href="logout">Logout</a></li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <!--  -------------------------------------------------------------------------------- -->
	
	<div class="container">
	
	<!-- ****************************if not items******************************************* -->
	<c:if test="${empty items}">
					
   						<div class="row">
   							<div class="lightpurple">
   								<div class="col-lg-12">
   									<h5 class="brand-name text-center">No Accessories Added Yet! </h1>
   									
   								</div>
   							
   							</div>
   						
   						</div>
	</c:if>
	<c:if test="${not empty items}">
		
		<div id="prodList"><!-- start listing down all the products -->
			 <c:forEach var="item" items="${items }">
			 
			 <!-- ****************product description********************* -->
			 	<div class="row">
			 		<div class="bongbox">
			 			<div class="col-lg-12">
			 				<hr>
     							<h2 class="intro-text text-center">
                        
                        			<strong>${item.name}</strong>
                				</h2>
                			<hr>
			 				<div class="row">
                				<div class="col-lg-6">
               	 					<label>Price</label><br/>
                					<p>${item.price}</p>
     							</div>
     							<div class="col-lg-6">
     								<label>Quantity Available</label>
     								<p>${item.quantity}</p>
     							</div>
     						</div>
			 				<hr>
     						<h2 class="intro-text text-center">
                     			<button class="btn btn-primary buyProd">Buy !</button>  
                     			<input type="hidden" value="${item.name }"/>
                     			
                     			
                        
                			</h2>
                			<hr>
			 			
			 			</div>
			 		
			 		
			 		</div>
			 	
			 	</div>
			 <!-- ****************buy area********************* --> 	
			 	<div class="buy" >
					<div class="row">
						<div class="lightpurple">
							<div class="col-lg-12">
								<hr>
								<h2 class="intro-text text-center">

									<strong> Buy Product </strong>
								</h2>
								<hr>
					 			<form:form class="form-login"  method="POST" action="buyItem" commandname="item">							
													
									<p>
										<input type="hidden" name="Id" value="${item.id }"/>
										<input type="text" name="name" value="${item.name }"
											autocomplete="off" class="form-control placeholder-no-fix" readonly="true">
										<input type="number" name="price" value="${item.price }"
											autocomplete="off" class="form-control placeholder-no-fix" readonly="true">
										<input type="number" name="quantity"
											placeholder="Choose Quantity" autocomplete="off"
											class="form-control placeholder-no-fix">
									</p>
									</br>
									<button type="submit" name="buy"
									class="btn btn-primary">Buy Product</button>
													

												
								</form:form>								


							</div>


						</div>


					</div>
				</div>
			 	
			  


			</c:forEach>
		
		
		
		</div>
	
	</c:if>
	
	
	
	
	
	</div><!-- main container -->
	
	<!--footer-->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Bulleteers Club</p>
                </div>
            </div>
        </div>
    </footer>
    
    
<script>
$(document).ready(function(){
	$(".buy").hide();
	
	
})
</script>

<script type="text/javascript" src="resources/assets/js/source/backstretch.js"></script>
   <script type="text/javascript">
   $.backstretch("resources/assets/images/bg1.jpg");
   </script>
<script type="text/javascript" src="resources/assets/js/build/displayBuyBox.js"></script>
</body>
</html>