(function($) {
    
    "use strict";

    //Begin Loading Handler
    $(window).load(function() {
        $("#loader").delay(800).fadeOut();
        $("#cover").delay(1200).fadeOut("slow");
    });

    // Go to the page top
    var backToTop = $(".back-to-top").hide();
    $(window).scroll(function(){
        if ( $(this).scrollTop()>100 ){
            backToTop.fadeIn(1300);
        } else {
            backToTop.fadeOut(1300);
        }
    });

    //back to top
    backToTop.on("click", function (){
        $('body,html').animate({scrollTop:0},800);
        return false;
    });

    // For Menu
    $(window).resize(function() {
        if( $(this).width() > 991 ) {
            $('ul.sub-nav').attr('style', '');
        }
    });

    //Main slider (OWL) Home Page
    $('#main-slider.carousel').carousel({
        interval: 8000,
        singleItem : true,
        transitionStyle : "goDown"
    });
    
    // Dream Type Style
     $(".typed-from-js").typed({
        strings: ["Loss", "Express", "News"],
        cursorChar: " ",
        typeSpeed: 100,
        loop: true,
        loopCount: true,
    });


     // SLIDER WIDTH THUMBNAIL or, SHOWCASE FEATURE SLIDER AREA 
    function syncPosition(el) {
        var current = this.currentItem;
        var showcase_thumb_slider  = $("#showcase-thumb-slider");
        showcase_thumb_slider
            .find(".owl-item")
            .removeClass("served")
            .eq(current)
            .addClass("served");
        if (showcase_thumb_slider.data("owlCarousel") !== undefined) {
            center(current)
        }
        el.find('.owl-wrapper').css({
            width: '',
            transform: ''
        });
    }
    function center(number) {
        var showcase_thumb_slider  = $("#showcase-thumb-slider");
        var thumbnail_slidervisible = showcase_thumb_slider.data("owlCarousel").owl.visibleItems;
        var num                     = number;
        var found                   = false;
        for (var i in thumbnail_slidervisible) {
            if (num === thumbnail_slidervisible[i]) {
                var found = true;
            }
        }

        if (found === false) {
            if (num > thumbnail_slidervisible[thumbnail_slidervisible.length - 1]) {
                showcase_thumb_slider.trigger("owl.goTo", num - thumbnail_slidervisible.length + 2)
            } else {
                if (num - 1 === -1) {
                    num = 0;
                }
                showcase_thumb_slider.trigger("owl.goTo", num);
            }
        } else if (num === thumbnail_slidervisible[thumbnail_slidervisible.length - 1]) {
            showcase_thumb_slider.trigger("owl.goTo", thumbnail_slidervisible[1])
        } else if (num === thumbnail_slidervisible[0]) {
            showcase_thumb_slider.trigger("owl.goTo", num - 1)
        }

    }

    var showCaseSlider = $("#showcase-main-thumb-slider-section");
    if ( showCaseSlider.length > 0 ) {

        var showcase_main_image_slider = $("#showcase-main-area-slider"),
            showcase_thumb_slider  = $("#showcase-thumb-slider");

        showCaseSlider.find('.items').each(function(){
            var imgContainer = $(this).find('.img-pot');
            imgContainer.css('background-image', 'url(' + imgContainer.data('bg-img') + ')');
        });

        showcase_main_image_slider.owlCarousel({
            addClassActive:        !0,
            singleItem:            true,
            slideSpeed:            1000,
            navigation:            false,
            pagination:            false,
            autoPlay:              true,
            afterAction:           syncPosition,
            responsiveRefreshRate: 200,
        });

        showcase_thumb_slider.owlCarousel({
            items:                 3,
            itemsDesktop:          [1199, 3],
            itemsDesktopSmall:     [991, 3],
            itemsTablet:           [768, 3],
            itemsMobile:           [479, 3],
            pagination:            false,
            responsiveRefreshRate: 100,
            afterInit:             function (el) {
                el.find(".owl-item").eq(0).addClass("served");
            }
        });

        showcase_thumb_slider.on("click", ".owl-item", function (e) {
            e.preventDefault();
            if( $(this).hasClass('served') ) {
                return;
            }
            var number = $(this).data("owlItem");
            showcase_main_image_slider.trigger("owl.goTo", number);
        });

    }
    
    
    // carousel to mobile tuchabale
    $('.carousel').each(function() {
        var el = $(this);
        el.swiperight(function() {  
            el.carousel('prev');  
        }); 
        el.swipeleft(function() {  
            el.carousel('next');  
        }); 
    }); 



    // Property Search Area
    $(".more-options").on("click", function (){
        $(".more-options").toggleClass("show-element");
        $(".property-content").toggleClass("remove-margin");
    });

    $('.property-search-form .more-options').on('click', function (e) {
        e.preventDefault();
        if ($(this).siblings('.advanced-search-sec').length > 0) {
            $(this).siblings('.advanced-search-sec').slideToggle(function () {
                $(window).trigger('resize.px.parallax');
            });
            $(this).parents('.property-search-form').toggleClass('opened');
        } else {
            $(this).parents('.main-search-sec').siblings('.advanced-search-sec').slideToggle(function () {
                $(window).trigger('resize.px.parallax');
            });
            $(this).parents('.property-search-form').toggleClass('opened');
        }

    });

    //Setup price slider (Price Range)
    var priceSlider = $(".priceSlider");
    if( priceSlider.length> 0 ) {
        var Link = $.noUiSlider.Link;

        priceSlider.noUiSlider({
             range: {
              'min': 500,
              'max': 80000,
            },
            start: [19480, 50800],
            step: 1000,
            margin: 0,
            connect: true,
            direction: 'ltr',
            orientation: 'horizontal',
            behaviour: 'tap-drag',
            serialization: {
                lower: [
                    new Link({
                        target: $("#price-min")
                    })
                ],
                upper: [
                    new Link({
                        target: $("#price-max")
                    })
                ],
                format: {
                // Set formatting
                    decimals: 0,
                    thousand: ',',
                    prefix: '$'
                }
            }
        });
    }

    // WoW Js
    new WOW().init();

})(jQuery);



