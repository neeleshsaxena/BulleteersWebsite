/**
 * 
 */



$(".joinTheRide").click(function(){
	

//alert("ghussa");


var rideId = $(this).next().next().val();
var tick = $(this).next();
var alert = $(this).next().next().next().next().next().next();
//alert(rideId);


$.ajax({
    type:"POST",          
    url:"joinRide",
    data:{rideId:$(this).next().next().val()},
    success:function(returnData,status){
      
     
        if(returnData==="added"){
        	
        	
        	pop.call(tick);
        }
        else if(returnData==="alreadyadded"){
        	
        	oho.call(alert);
        	
        }
      
    },
    error:function(returnData,status){
      alert(returnData);
      alert("Error!");
      console.log(returnData);
    }
  });




});

function pop(){
	
	$.notify({
		icon: 'fa fa-paw',
		message: "Welcome to the Club. Ride On!"
	});
	
	this.show();
	
};
function oho(){
	
	$.notify({
		icon: 'fa fa-paw',
		message: "Ping Your Members and create Mayhem"
	});
	
	this.show();
	
};

