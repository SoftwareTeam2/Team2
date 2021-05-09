window.onload=function(){
    var sliderContainer = document.getElementsByClassName('slider-container'),
        slides = document.getElementsByClassName('slide'),
        slideCount = slides.length;
        currentIndex = 0,
        topHeight = 0,
        videoIndex=0,
        nevPrev = document.getElementById('prev'),
        nevNext = document.getElementById("next"),
        nevHPrev = document.getElementById('hidden-prev'),
        nevHNext = document.getElementById("hidden-next");
        
        for(var i=0;i<slideCount;i++){
            slides[i].style.left=i*100+'%';
        }
        function goToSlide(idx){
            sliderContainer[0].classList.add('animated');
            sliderContainer[0].style.left=idx*-100+'%';
            videoIndex=currentIndex;
            currentIndex = idx;
            stopVideo(slides[videoIndex]);
        }
        var stopVideo = function ( element ) {
            var iframe = element.querySelector( 'iframe');
            var video = element.querySelector( 'video' );
            if ( iframe !== null ) {
                var iframeSrc = iframe.src;
                iframe.src = iframeSrc;
            }
            if ( video !== null ) {
                video.pause();
            }
        };
        nevNext.addEventListener('click',function(event){
            event.preventDefault();
            if(currentIndex==slideCount-1)
                goToSlide(0);
            else
                goToSlide(currentIndex+1);
            
        });
        nevPrev.addEventListener('click',function(event){
            event.preventDefault();
            if(currentIndex==0)
                goToSlide(slideCount-1);
            else
                goToSlide(currentIndex-1);
            
        });
        nevHNext.addEventListener('click',function(event){
            event.preventDefault();
            if(currentIndex==slideCount-1)
                goToSlide(0);
            else
                goToSlide(currentIndex+1);
            
        });
        nevHPrev.addEventListener('click',function(event){
            event.preventDefault();
            if(currentIndex==0)
                goToSlide(slideCount-1);
            else
                goToSlide(currentIndex-1);
        });
         goToSlide(0);
    };