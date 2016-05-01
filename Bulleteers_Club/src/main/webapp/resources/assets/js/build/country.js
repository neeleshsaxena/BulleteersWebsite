/**
 * 
 */

$("#list").keypress(function() {
     
      var thisCountry = $(this).val();   
     
      //alert(ca);  
      $.get( //shorthand notation for $.ajax(type="GET")
          "countries",
          {country:thisCountry},
          function(reponseData,status){
            
            console.log(reponseData);
            $("#countrylist option:last").after(reponseData);
            
          }
      );
    });

