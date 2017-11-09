<?
## RESPONSAVEL PELAS CATEGORIAS DO SITE   EX: RELATORIOS/CONEXOES..
class Leis extends Configuracoes{
	
	//Conexao com o Banco de Dados
	function inserir($titulo, $anexo){
		$sql = parent::conectar();
		
		$novaData = parent::gerarData();
		
		$qr = $sql->prepare('insert into tb_leis(id, titulo, anexo, data) values(NULL, ?, ?, ?)');
		$qr->bind_param('sss', $titulo, $anexo, $novaData);
		
		$qr->execute();
		return $qr;
	}
	
	//SELECAO DO BANCO DE DADOS
	function selecionar($id, $ordem, $limite){
		$sql = parent::conectar();
		
		$select = "select * from tb_leis ";
		$select .= $id != null ? " where id={$id}" : "";
		$select .= $ordem != 'asc' ? " order by ordem desc" : " order by ordem asc";
		$select .= $limite != false ? " limit {$limite}" : "";
		
		$qr = $sql->query($select);
		return $qr;

	}
	
	function editar($id, $titulo, $anexo){
		$sql = parent::conectar();
		
		$qr = $sql->prepare('update tb_leis set titulo = ?, anexo = ? where id = ?');
		$qr->bind_param('ssi', $titulo, $anexo, $id);
		
		$qr->execute();
		return $qr;
	}
	
	//EXCLUSAO DO BANCO DE DADOS
	function excluir($id){
		$sql = parent::conectar();
			
		$qr = $sql->prepare("delete from tb_leis where id = ?");
		$qr->bind_param("i", $id);
		
		$qr->execute();
		return $qr;
	}
	
	function updateOrdem($ordem, $id){
		$sql = parent::conectar();
		
		$qr = $sql->prepare('update tb_leis set ordem = ? where id = ?');
		$qr->bind_param('ii', $ordem, $id);
		
		$qr->execute();
		return $qr;	
	}
	
	
	function selecionarAjax($texto){
		$sql = parent::conectar();
		
		$select = "select * from tb_leis where titulo like '%{$texto}%'";
		
		$qr = $sql->query($select);
		return $qr;
	}
	

}
?>