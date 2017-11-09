// JavaScript Document

var posicaoScroll = null;
$(document).ready(function(){
    $(window).scroll(function() {
        var posicaoScroll = $(document).scrollTop();
        
        if ($(window).width() > 999) {
            if (posicaoScroll > 100) {
				$('.box-conteiner-topo').css({position:'fixed',zIndex:'5'});
				$('.logo').css({width: "200px",marginTop:'-15px'});
				$('nav').css({marginTop:'20px'})
				$('.bg-scroll-menu').css({zIndex:'2'});
            } else {
				$('.box-conteiner-topo').css({position:'relative',zIndex:'5',float:'left'});
				$('.logo').css({width: "310px",marginTop:'3'});
				$('nav').css({marginTop:'40px',})
				$('.bg-scroll-menu').css({zIndex:'-2'});
            }
        }
    });
	
	
	
	//ajax leis
	$('#buscaLeis').keyup(function(){
		var texto = $(this).val();
		
		$.ajax({
				type:"POST",
				url:"pesquisa.php",
				data:{
					acao:'pesquisar',
					texto:texto
				},
				dataType:"html",
				success: function(retorno){
					$('#retorno').html(retorno);	
				}
			});
		});
	});


(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/pt_BR/all.js#xfbml=1&appId=238034926269899";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

$(document).ready(function(e) {
	hs.graphicsDir = '../../js/highslide/graphics/';
	hs.align = 'center';
	hs.transitions = ['expand', 'crossfade'];
	hs.outlineType = 'rounded-white';
	hs.fadeInOut = true;
	//hs.dimmingOpacity = 0.75;

	// Add the controlbar
	hs.addSlideshow({
		//slideshowGroup: 'group1',
		interval: 3000,
		repeat: false,
		useControls: true,
		fixedControls: 'fit',
		overlayOptions: {
			opacity: 0.75,
			position: 'bottom center',
			hideOnMouseOut: true
		}
	});
	
});