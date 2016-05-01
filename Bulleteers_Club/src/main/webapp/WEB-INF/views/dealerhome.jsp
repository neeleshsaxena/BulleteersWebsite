<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
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

 <div class="container">
 	
 	<!-- ****************header container********************************** -->
 	<div class="row">
 		<div class="offwhite">
 			<div class="col-lg-12">
 				
 				 <h1 class="brand-name text-center">Product Inventory </h1>
 			
 			</div>
 		
 		</div>
 	
 	
 	</div>
 	
 	<!-- ***************side bar and the product list in one row******************************** -->
 	<div class="row">
 		
 		<!-- ***************side bar ******************************** -->
 			<div class="col-lg-2 offwhite">
 				</br>
 				</br>
 				<h3 class="name text-center"> Hi ${dealer.firstName }</h4>
 				</br>
 				</br>
 				</br>
 				 <button type="btn btn-success
                              " class="btn btn-success center-block" data-toggle="modal" data-target="#addProd" >Add Products    </button>
          <!-- ********************modal for adding new products******************************** --> 
                             
                <form:form class="form-login"  method="POST" action="addItem" commandname="item">
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="addProd" class="modal fade">
		          
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header" color="blue">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Add a Product</h4>
		                      </div>
		                      <div class="modal-body register">
		                      	  <p><input type="text" id="na" name="name" required placeholder="Product Name" autocomplete="off" class="form-control placeholder-no-fix"></p>
		                          <p><input type="number" id="pr" name="price" required placeholder="Enter Price" autocomplete="off" class="form-control placeholder-no-fix"></p>
		                          <p><input type="number" id="qu" name="quantity" required placeholder="Enter Quantity" autocomplete="off" class="username form-control placeholder-no-fix"><h4></h4></p>
		                          
		                         
		                      	  
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <button class="create btn btn-theme" id="saveProd" type="submit">Add Product</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		       </form:form>
                              </br>
                              </br>
                              </br>
                              </br>
                              </br>
                              </br>
                              <a class="btn btn-danger center-block" href="logout">Logout </a> 
 			
 			</div>
 			
 		<!-- ***************side bar end******************************** -->	
 		
 		<!-- ***************product list******************************** -->
 			<div class="col-lg-10 ">
 				
 				 
 				 
 				 
 				 <!-- ************** blocks of products***************************** -->

 <!-- ************** if products empty then this***************************** -->
					<c:if test="${empty items}">
					
   						<div class="row">
   							<div class="lightpurple">
   								<div class="col-lg-12">
   									<h5 class="brand-name text-center">No Products Added Yet! </h1>
   									
   								</div>
   							
   							</div>
   						
   						</div>
					</c:if>
					
					
<!-- ************** if products not empty then this***************************** -->					
					<c:if test="${not empty items}">


						<div class="bod">
							<c:forEach var="item" items="${items }">
								<div class="row">
									<div class="lightpurple">
										<div class="col-lg-12">
											<hr>
											<h2 class="intro-text text-center">

												<strong>${item.name }</strong>
											</h2>
											<hr>
											<div class="row">
												<div class="col-lg-6">
													<label>Price </label><br />
													<p>${item.price }</p>
												</div>
												<div class="col-lg-6">
													<label>Quantity </label>
													<p>${item.quantity }</p>
												</div>
											</div>
											
											<hr>
											<h2 class="intro-text text-center">
												<button class="btn btn-primary editProduct">Edit the Product</button>
												
												
												</br>
												

											</h2>
											<hr>
										</div>

									</div>

								</div>
								<!--  **********************Edit Product****************************** -->
								<div class="edit" >
									<div class="row">
										<div class="bongbox">
											<div class="col-lg-12">
												<hr>
												<h2 class="intro-text text-center">

													<strong> Edit Product </strong>
												</h2>
												<hr>
					 <form:form class="form-login"  method="POST" action="editItem" commandname="item">							
													
													<p>	
															<input type="hidden" name="Id" value="${item.id }"/>
															<input type="text" 
															name="name" value="${item.name }" 
															autocomplete="off"
															class="form-control placeholder-no-fix" required>
															<input type="number" 
															name="price"  placeholder="Edit Price"
															autocomplete="off"
															class="form-control placeholder-no-fix" required>
															<input type="number" 
															name="quantity"  placeholder="Edit Quantity"
															autocomplete="off"
															class="form-control placeholder-no-fix" required>
													</p>
													</br>
													<button type="submit" name="buttonmessage"
														class="btn btn-primary sendMess">Edit Product</button>
													

												
								</form:form>								


											</div>


										</div>


									</div>
								</div> 



							</c:forEach>
						</div>









					</c:if>
					</div>
 		
 		</div>
 	
 	
 	</div>
 
 
 
 
 
 </div><!-- container end -->








</script>
<script>
$(document).ready(function(){
	$(".edit").hide();
	
	
})
</script>
<script type="text/javascript" src="resources/assets/js/source/backstretch.js"></script>
   <script type="text/javascript">
   $.backstretch("resources/assets/images/dealerback.jpg");
   </script>
   <script type="text/javascript" src="resources/assets/js/build/displayEditItem.js"></script>
   <script type="text/javascript" src="resources/assets/js/source/bootstrap-notify.js"></script>
   <script type="text/javascript" src="resources/assets/js/source/bootstrap-notify.min.js"></script>
</body>
</html>