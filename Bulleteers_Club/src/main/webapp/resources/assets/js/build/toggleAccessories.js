/**
 * 
 */

 $("#make").mouseenter(function()
    {
        
        $("div#outer").fadeOut();
        $("div#text").fadeIn();
     }); 

     $("#make").mouseleave(function()
     {
        
         $("div#text").fadeOut();
        $("div#outer").fadeIn();
     });  
     
     $('.carousel').carousel({
         interval: 5000 //changes the speed
     })