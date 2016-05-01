<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Bulleteers Club</title>
</head>
<body>

<!--  insert the name of the club dynamically -->

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
                <a class="navbar-brand" href="#">${club.clubName } Club</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <!--  -------------------------------------------------------------------------------- -->
            <!--  add name of the member here -->
            <!--  -------------------------------------------------------------------------------- -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <i class="fa fa-motorcycle intro-text" > Welcome ${member.firstName }</i>
                <ul class="nav navbar-nav">
                   
                    <li>
                        <a href="#">Home</a>
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
    
    
    <div class ="container" id="cont">
    
    
    <!-- carousal with random pictures------------------------------------------------------- -->
    
    <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                    <div id="carousel-example-generic" class="carousel slide">
                        <!-- Indicators -->
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="img-responsive img-full" src="resources/assets/images/slide-1.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="resources/assets/images/ride5.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="resources/assets/images/ride6.jpg" alt="">
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>

                    <h2 class="brand-before">
                        <small>Welcome to</small>
                    </h2>
                    
                    <!-- ---------------------------------------------------------------- -->
                    <h1 class="brand-name">${club.clubName }</h1>
                    <!--  Add club Name -->
                    <!-- ---------------------------------------------------------------- -->
                    <hr class="tagline-divider">
                    <h2>
                        <small>By</br>
                            <strong>Sons Of Anarchy</strong>
                        </small>
                    </h2>
                </div>
            </div>
        </div>
    
    
    <!-- --------------------------------------------------------------------------------------- -->
 	<!-- Provide them a link to list all the rides on a different page along with their description -->
 	
 	<div class="row" id="make">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">
                        <strong>Check out the Customized Accessories</strong>
                    </h2>
                    <hr>
                    <div id="outer">
                    <img class="img-responsive " src="resources/assets/images/acc.jpg" alt="" id="img1">
                    </div>

                    <hr class="visible-xs">
                        <div id="text">
                            <p> Find the upcoming rides. See what the petrol heads across the Globe are converging towards. Join the excitement, camaraderie, and burnt rubber by registering for the rides!</p>
                            <p>I'm going to focus on the performance side of building a cafe racer. 
                            Or street tracker, scrambler, or any custom motorcycle, for that matter. 
                            Let's start by picking the right bike up front to avoid expensive mistakes down the track.</p>
                            <p>Yamaha has the XS series, in 360, 400 or 650 capacities. Forget the XS500 or TX500, 
                            unless you've got tons of time and money. Then there's the SR400 and SR500, 
                            and even the Viragos are now getting lots of attention.</p>
                            <p>From Kawasaki, you can pick a Z of any size. But it was Suzuki that produced some of the best air-cooled inline fours, 
                            like the GS750/1000s which is why Pops Yoshimura gave them so much love. And why you see hardly any for sale these days.</p>
                            <p>Lessons were learned and improvements were made. As the bikes were pushed to their performance limits at the racetrack,
                            improvements gradually made their way into production models. 
                            These lessons, tricks, new parts and tuning secrets have since continued to gather, so we now have a huge pool of knowledge.</p>
                             <hr>   
                            <a href="displayAccessories" class="btn btn-default btn-lg butt">Browse </a>    
                        </div>

                </div>
            </div>
        </div>
        
        <!--  ------------------------------------------------------------------------------------------------------------- -->
        
        <!-- -----------------------Allow the members to create their own Ride-------------------------- -->
        <!-- --------------Modal will pop out and the member will fill out all the details of the ride -->
        
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">
                        <strong>Register Your own Ride</strong>
                    </h2>
                    <hr>
                    <p>Register yourself and enter your own rider pack. Select destinations and routes. Allow your brothers to join you in another crazy journey</p>
                    <p>Register yourself as a member before forming a pack.</p>
                    
                    
                    <hr>   
                    <a data-toggle="modal" href="#registerRide" class="btn btn-default btn-lg butt">Register</a> 
                </div>
            </div>
        </div>
        <!-- Modal -->
        
	 <form:form class="form-login"  method="POST" action="rideRegister" commandname="ride">
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="registerRide" class="modal fade">
		          
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header" color="blue">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Create a Ride</h4>
		                      </div>
		                      <div class="modal-body register">
		                      	  <p><input type="text" id="des" name="description" required placeholder="Ride Description" autocomplete="off" class="form-control placeholder-no-fix"></p>
		                          <p><input type="date" id="strt" name="startdate" required placeholder="Start Date" autocomplete="off" class="form-control placeholder-no-fix"></p>
		                          <p><input type="date" id="end" name="enddate" required placeholder="End Date" autocomplete="off" class="username form-control placeholder-no-fix"><h4></h4></p>
		                          <p><input type="number" id="day" name="days" required placeholder="Number of Days" autocomplete="off" class="username form-control placeholder-no-fix"><h4></h4></p>
		                          <p><input id="roadcaptain" id="cap" type="text" required name="roadcaptain" placeholder="Road Captain" autocomplete="off" class="form-control placeholder-no-fix"></p>
		                         
		                      	  
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <button class="create btn btn-primary" id="saveRide" type="submit">Create</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		       </form:form>
	
   <!--------------------------------------Start off the blog here------------------------------------------- -->     
        
 	<!--  -----------------------------Add the rides for a club---------------------------------- -->
 	   
    
    <div class="addride">
    <div class="bod">
     <c:forEach var="ride" items="${rides }">
     	<div class="row">
     		<div class="purplebox">
     			<div class="col-lg-12">
     			<hr>
     			<h2 class="intro-text text-center">
                        
                        <strong>${ride.description }</strong>
                </h2>
                <hr>
                	<div class="row">
                		<div class="col-lg-6">
               	 			<label>Ride Road Captain</label><br/>
                			<p>${ride.roadcaptain }</p>
     					</div>
     					<div class="col-lg-6">
     						<label>Ride Duration</label>
     						<p>${ride.days }</p>
     					</div>
     				</div>
     				<div class="row">
                		<div class="col-lg-6">
               	 			<label>Ride StartDate</label><br/>
                			<p>${ride.getStartDateString() }</p>
     					</div>
     					<div class="col-lg-6">
     						<label>Ride EndDate</label>
     						<p>${ride.getEndDateString() }</p>
     					</div>
     				</div>
     				<div class="row">
                		<div class="col-lg-12">
                			<div class="project-wrapper">
                            <div class="project">
                                <div class="photo-wrapper">
                                    <div class="photo">
                                      <a class="fancybox" href="${ride.getRidePicPath()}"><img onerror="this.src='resources/assets/images/abc.jpg';" class="img-responsive rideIm" alt="Ride Pic" src="${ride.getRidePicPath()}"></a>
                                    </div>
                                    <div class="overlay"></div>
				                    <div class="registration">
				                    
						                <span>
						                    <a data-toggle="modal" class="btn btn-primary picmodal" id="${ride.rideId }" href="profile.html#imageUpload"> Change Ride Picture</a>
						                </span>
						            
						            </div>
                                </div>
                            </div>
                        </div>
               	 		
     					</div>
     				</div>
     				<hr>
     				<h2 class="intro-text text-center">
                     <button class="btn btn-primary joinTheRide">Join the Ride</button>  <span class="glyphicon glyphicon-ok ridetick"></span>
                     <input type="hidden" value="${ride.rideId}"/>
                     <button  class="btn btn-primary clickMem" >View Members</button></br></br>   
                     <span class="alert alreadyadded">Already A Member Bro!</span>
                        
                </h2>
                <hr>
     			</div>
     		
     		</div>
     	
     	</div>
     	 <!--  **********************Members listing****************************** -->
     	<div class="mems" id="${ride.rideId }ride ">
     	<div class="row" >
     		<div class="bongbox">
     			<div class="col-lg-12">
     				<hr>
     			<h2 class="intro-text text-center">
                        
                        <strong> Gang Members </strong>
                </h2>
                <hr>
                <c:forEach var="member" items="${ ride.member}" varStatus="memberCount">
                	<p > ${member.firstName }  <i class="fa fa-weixin memclicked" aria-hidden="true"></i></p> 
                	<p><input type="text" id="num-${memberCount.index }" name="message" required placeholder="Enter Message" autocomplete="off" class="form-control placeholder-no-fix mess"></p></br>
                	<button name="buttonmessage" class="btn btn-primary sendMess" >Send Message</button>
                	<span class="glyphicon glyphicon-ok messagetick"></span>
                	
                </c:forEach>
     				
     				
     			
     			</div>
     		
     		
     		</div>
     	
     	
     	</div>
     </div>
     
     
     
     </c:forEach>
    </div>
    
   
   
    
    </div>
    
    
    
    </div> <!-- container ends -->
    
    
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
    
    
    
<!-- ****************************modal for pic************************************** -->
 <div aria-hidden="true" aria-labelledby="ImageUpload" role="dialog" tabindex="-1" id="imageUpload" class="modal fade">
      <form method="POST" action="upload" enctype="multipart/form-data">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Upload Your Ride Picture</h4>
		                      </div>
		                      
		                      <div class="modal-body">
		                          <p>Browse Files to upload</p>
								  <input type="file" name="ridePic"/>
								  <input type="hidden" id="up" name="rideId" value=""/>
		                      </div>
		                      
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <input class="btn btn-theme" value="Submit" type="submit"/>
		                      </div>
		                      
		                  </div>
		              </div>
		              </form>
		          </div>

<!-- ****************************************modal end*********************************************** -->


<script>
$(document).ready(function(){
	$(".mems").hide();
	
	
})
</script>
<script type="text/javascript">

$(document).on("click", ".picmodal", function () {

	var  a = $(this);
	var id = a.attr("id");
	
    
    $(".modal-body #up").val( id );
    
});



</script>

<script type="text/javascript" src="resources/assets/js/source/backstretch.js"></script>
   <script type="text/javascript">
   $.backstretch("resources/assets/images/bg1.jpg");
   </script>
<script type="text/javascript" src="resources/assets/js/build/joinRide.js"></script>
<script type="text/javascript" src="resources/assets/js/build/displayMembers.js"></script> 
<script type="text/javascript" src="resources/assets/js/build/sendMessage.js"></script>
<script type="text/javascript" src="resources/assets/js/build/readNotification.js"></script>
<script type="text/javascript" src="resources/assets/js/source/bootstrap-notify.js"></script>
<script type="text/javascript" src="resources/assets/js/source/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="resources/assets/js/build/toggleAccessories.js"></script>   
</body>
</html>