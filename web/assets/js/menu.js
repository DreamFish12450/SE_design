(function($) {
    
    "use strict";

    window.stickyNav = {};
    var header = $(".header.fixed");

    $(window).on('scroll', function() {
        if (typeof stickyNav.scrollTop === 'undefined') {
            stickyNav.scrollTop = 0;
        }
        if ($(this).scrollTop() > stickyNav.scrollTop) {
            $(this).trigger('downscroll');
        } else {
            $(this).trigger('upscroll');
        }
        stickyNav.scrollTop = $(this).scrollTop();
    });

	$(window).scroll(function(){
		if( $(this).scrollTop() > 120 ) {
		 	header.addClass("trim");
		} else {
			header.removeClass("trim");
		}
	});

    function initStickyMenu() {
        stickyNav.stickyHeader = {};
        stickyNav.stickyHeader.elm = header;
        stickyNav.stickyHeader.tmp = {};
        stickyNav.stickyHeader.scrollTop = 0;
        stickyNav.stickyHeader.headerHeight = stickyNav.stickyHeader.elm.height();
        stickyNav.stickyHeader.limit = stickyNav.stickyHeader.headerHeight * 2;
        if ($('body').hasClass('admin-bar')) {
            stickyNav.stickyHeader.scrollTop = $('#wpadminbar').height();
        }
        $(window).on('downscroll', function() {
            stickyNav.stickyHeader.elm.not('.full').removeClass("scroll-down");
        }).on('upscroll', function() {
			if( $(this).scrollTop() > 120 ) {
	            stickyNav.stickyHeader.elm.addClass("scroll-down");
	        } else {
	        	stickyNav.stickyHeader.elm.removeClass("scroll-down");
	        }
        });
    }

	$(document).ready(function(){	
		// Main Menu
		$(".main-menu ul.main-nav li:has(>ul)").addClass("has-children");
		
		if($(".main-menu ul.main-nav li").hasClass("has-children")){
			$(".main-menu ul.main-nav li.has-children").prepend('<span class="toggle-submenu"></span>')
		}
		
		if($(".header").hasClass("fixed")){
			$("body").addClass("header-fixed");
		}
		
		$('.main-menu-deputy .menu-when-collapse').on("click", function (){
			$("html").addClass("overflow-hidden");
			$("body").addClass("overflow-hidden");
			$(".main-menu").addClass("toggle-nav");
			$(".menu-collapse-after-effect").addClass("show-casing");
		});
		$('.menu-collapse-after-effect').on("click", function (){
			$("html").removeClass("overflow-hidden");
			$("body").removeClass("overflow-hidden");
			$(".main-menu").removeClass("toggle-nav");
			$(".menu-collapse-after-effect").removeClass("show-casing");
			$(".main-menu ul.main-nav li").removeClass("active");
			if($(".main-menu ul.main-nav li ul").hasClass("opened")){
				$(".main-menu ul.main-nav li ul").removeClass("opened").slideUp(200);
			}
		});
		$('.close-nav').on("click", function (){
			$("html").removeClass("overflow-hidden");
			$("body").removeClass("overflow-hidden");
			$(".main-menu").removeClass("toggle-nav");
			$(".menu-collapse-after-effect").removeClass("show-casing");
			$(".main-menu ul.main-nav li").removeClass("active");
			if($(".main-menu ul.main-nav li ul").hasClass("opened")){
				$(".main-menu ul.main-nav li ul").removeClass("opened").slideUp(200);
			}
		});
		$('.main-menu ul.main-nav li span').on("click", function (){
			if($(this).siblings('ul').hasClass('opened')){
				$(this).siblings('ul').removeClass('opened').slideUp(200);
				$(this).closest('li').removeClass('active');
			}
			else{
				$(this).siblings('ul').addClass('opened').slideDown(200);
				$(this).closest('li').addClass('active');
			}
		});

		initStickyMenu();
	
	});

})(jQuery);