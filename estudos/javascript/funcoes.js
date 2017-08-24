function $(id){
	return document.getElementById(id);
}

function validarCampo(id, mensagem){
	var valor = $(id).value;
	
	if (valor.trim() == ""){
		if (adicionouMensagem){
			$("validacao").innerHTML = 
				$("validacao").innerHTML + "<br />";
		}
	
		$("validacao").innerHTML = 
		$("validacao").innerHTML + mensagem;

		adicionouMensagem = true;
	}
}
