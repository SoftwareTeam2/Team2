$(document).ready(function(){
    $(".open").click(function(){
     var submenu = $(this).next("ul");
     var icon = $('.icon');
      if(submenu.is(":visible") ){
            submenu.slideUp();
      }else{
            submenu.slideDown();
       }
    });
});