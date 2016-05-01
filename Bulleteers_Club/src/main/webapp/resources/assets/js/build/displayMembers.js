/**
 * 
 */


 $(".clickMem").click(function(){

	var a = $(this).parent().parent().parent().parent().next();
	
	
	a.toggle();
	
	var inp = a.find('input');
	var but = a.find('button');
	var tick = but.next();
	
	
	inp.hide();
	but.hide();
	tick.hide();
	
	 
	 	
	
	
	

})


 $(".memclicked").click(function(){
	 
	 var para = $(this).parent().next().children();
	 var butt = $(this).parent().next().next().next();
	 var tick = $(this).parent().next().next().next().next();
	 
	 para.toggle();
	 butt.toggle();
	
	 
	
	 
	 
	 //.next().show();
	 //$(this).parent().next().next().show();
//	 var inp = p.next();
//	 var but = inp.next();
//	 inp.show();
//	 but.show();
//	 console.log(inp);
//	 console.log(but);
	 
	 
 })


