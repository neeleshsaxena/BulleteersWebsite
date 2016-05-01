/**
 * 
 */

$("#usertxt").blur(function(){
	
            if( !$(this).val() ) {
                //field cannot be empty check
          $("#empty").show();
          $(this).next().hide();
          $(this).next().next().hide();

    }
    else{
        $.ajax({
          type:"POST",          
          url:"validateUser",
          data:{user:$("#usertxt").val()},
          success:function(returnData,status){
            
            if($.trim(returnData)===("exists"))
              {
              
                // if username already exists
                 
                nope();
                              
              }
            else{           
            //if username is not taken and valid      
                 yep();
                  
              }            
          },
          error:function(returnData,status){
            alert(returnData);
            alert("Error!");
            console.log(returnData);
          }
        });
}
      });

function nope(){
	
	$.notify({
		icon: 'fa fa-paw',
		message: "Sorry Mate! Please Choose another"
	});
	
	 $("#usertxt").next().next().hide();
     $("#empty").hide();
     $("#usertxt").next().show();
	
};

function yep(){
	
	$.notify({
		icon: 'glyphicon glyphicon-star',
		message: "Go Ahead! Take the patch!"
	});
	
	  $("#usertxt").next().hide();
      $("#empty").hide();
   $("#usertxt").next().next().show();
	
};