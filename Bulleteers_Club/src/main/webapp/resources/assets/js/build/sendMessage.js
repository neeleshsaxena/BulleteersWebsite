/**
 * 
 */



 $(".sendMess").click(function(){
	
	// var i = $(this).prev().prev().children().val();
//	 console.log(i);
//	 var txt = i.val();
	
	 
	 //var as = $(this).prev().prev().prev().text();
	 //var toName= as.text();
	 
	 var tick = $(this).next();
	 var warn = tick.next();
	 
	 
	 $.ajax({
         type:"POST",          
         url:"sendMessage",
         data:{toPerson:$(this).prev().prev().prev().text(),text:$(this).prev().prev().children().val()},
         success:function(returnData,status){
           
           if(returnData==="sort"){
        	   
        	  
        	   done.call(tick);
           }
           else{
        	   
        	   warn.show();
           }
        	 
         },
         error:function(returnData,status){
           alert(returnData);
           alert("Error!");
           console.log(returnData);
         }
       });
	 
	 
	 
	 
	 
	 
	 
 });
 
 function done(){
		
		
		
		$.notify({
			title: '<strong>Mayhem created!</strong>',
			message: 'Message Sent.'
		},{
			type: 'success'
		});
		
		this.show();
		
	};
	
	

