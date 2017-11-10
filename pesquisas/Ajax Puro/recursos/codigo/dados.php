<?php
	$name = (isset($_POST['nome'])) ? $_POST['nome'] : 'Nao ha nome';

	$mensagem = "Ola ";
	$mensagem .= $name . ", agora sao ";
	$mensagem .= date("H") . " horas " . date("i") . " minutos e " . date("s") . " segundos ";
	
	echo $mensagem;
?>