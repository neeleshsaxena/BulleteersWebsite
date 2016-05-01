/**
 * 
 */


$("#notCount").click(function(){
	
	 $.ajax({
         type:"POST",          
         url:"readNotification",
         data:{msg:"read"},
         success:function(returnData,status){
           
           if(returnData==="sort"){
        	   //set the count to 0
//        	   var num = $("#notCount").parent();
//        	   num.text("0");
//        	   console.log(num);
        	  
           }
           else{
        	   alert("cann");
           }
        	 
         },
         error:function(returnData,status){
           alert(returnData);
           alert("Error!");
           console.log(returnData);
         }
       });



})


