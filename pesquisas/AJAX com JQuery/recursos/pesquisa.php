<?
	include_once("../painel/class/Configuracoes.class.php");
	$config = new Configuracoes;
	$config->conectar();
	
	include_once("../painel/class/Leis.class.php");
	$leis = new Leis;
	
	
	if(isset($_POST['acao'])&&$_POST['acao'] == 'pesquisar'){
		
		$resultado = $leis->selecionarAjax($_POST['texto']);
		

		while($linha = $resultado->fetch_array()){
?>
            <a target="_blank" href="anexos/<?=$linha['anexo']?>">
            <div class="leis">
                <h1><?=$linha['titulo']?></h1>
                <span class="data-publicacao"><?=$linha['data']?></span>
            </div>
            </a>

<?	
		}

 	} ?>