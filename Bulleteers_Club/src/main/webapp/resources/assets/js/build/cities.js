/**
 * 
 */


$("#citytxt").keypress(function() {
     
      var thisCity = $(this).val();   
     
      //alert(ca);  
      $.get( //shorthand notation for $.ajax(type="GET")
          "cities",
          {city:thisCity},
          function(reponseData,status){
            
            console.log(reponseData);
            $("#citylist option:last").after(reponseData);
            
          }
      );
    });


