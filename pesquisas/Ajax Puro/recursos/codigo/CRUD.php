<?php	
	switch(isset($_GET['opcao']) ? $_GET['opcao'] : "apagar"){
		case 'inserir':
			inserir();
		break;
		case 'apagar':
			apagar();
		break;			
	}
	
	function conectar(){
		$con = new mysqli("localhost", "root", "123456", "ajax");
		if($con->connect_errno){
			die("Nao foi possivel conectar, n do erro: " . $con->connect_errno . ", mensagem: " . $con->connect_error);              
		}
		
		return $con;
	}
	
	function apagar(){
		$conexao = conectar();
		if(isset($_GET['id'])){
			$id = $_GET['id'];				
			
			$conexao->query("delete from usuario where id = $id");
			$conexao->close();
		} else {
			
			$conexao->query("delete from usuario where id > 0");	
			$conexao->close();
		}
	}
	
	function inserir(){
		if(isset($_POST['nome'])){
			$nome = $_POST['nome'];				
		}
		if(isset($_POST['sexo'])){
			$sexo = $_POST['sexo'];				
		}	
		$conexao = conectar();
		
		$conexao->query("insert into usuario (nome, sexo) values ('$nome','$sexo')");
		
		$conexao->close();
	}
?>