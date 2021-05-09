function spin(){
    var angle = 0;
    var cnt = 0;
    var spinner = setInterval(function(){
    angle+=3;
    cnt++;
    $("#image").rotate(angle);
    if(cnt==200){
        clearInterval(spinner);
        $("#image").rotate(0);
        $('body').css('background','sienna');
        $('span').css('color','white');
        $('footer').css('background','white');
        $('footer').css('color','sienna');
        $('.menu-icon').attr('src','css/menu-icon-inversion.png');
        $('.hide>li:not(:last-child)').css('border-bottom','1px solid white');
    }
    },20);
}