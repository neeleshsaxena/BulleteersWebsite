/**
 * 
 */


$("#saveRide").click(function(){
	

	
		$(".rideadd").hide();
		
		
		
		//alert("Username: "+userName +"\nCoupleName: "+coupleName);
		
		$.ajax({
	          type:"POST",          
	          url:"addridebe",
	          data:{description:$("#des").val(),startdate:$("#strt").val(),enddate:$("#end").val(),days:$("#day").val(),captain:$("#cap").val()},
	          success:function(result,status){
	            
	           
	              
	                // if username already exists
	                 
	        	  $("#bod").html(result);
	                              
	                        
	          },
	          error:function(returnData,status){
	            alert(returnData);
	            alert("Error!");
	            console.log(returnData);
	          }
	        });
		
		
		
		
		
		$(".addride").show("slow");
	
	
	
});





