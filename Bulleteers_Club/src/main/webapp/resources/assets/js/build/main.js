 
   
      
      $("#usertxt").blur(function(){
            if( !$(this).val() ) {
          $(this).next().show();
          $("#usertxt").toggleClass("alertbox");
    }
      });

      $("#password").blur(function(){
            if( !$(this).val() ) {
          $(this).next().show();
          $("#usertxt").toggleClass("alertbox");
    }
      });
