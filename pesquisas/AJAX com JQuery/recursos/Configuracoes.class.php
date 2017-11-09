<?

## RESPONSAVEL PELAS CONFIGURACOES DO SITE   EX: RELATORIOS/CONEXOES..
class Configuracoes{
	
	//Conexao com o Banco de Dados
	function conectar(){
		$sql = new mysqli('localhost','sindcere_admin','84528223sind','sindcere_site');
		return $sql;
		
		/* seleciona o horario local */ 
        setlocale(LC_ALL, "ptb", "portuguese-brazil", "pt-br", "bra", "brazil");
        date_default_timezone_set("America/Sao_Paulo");
		
	}
	
	function inserirAtualizacao($msg){
		$sql = self::conectar();
		/* seleciona o horario local */
        setlocale(LC_ALL, "ptb", "portuguese-brazil", "pt-br", "bra", "brazil");
        date_default_timezone_set("America/Sao_Paulo");
		
		$ip = $_SERVER['REMOTE_ADDR'];
		$data = date('d/m/Y - H:m:s');
		
		$qr = $sql->prepare("insert into tb_atualizacoes(id, atualizacao, ip, data) values (NULL,?,?,?)");
		$qr->bind_param('sss', $msg, $ip, $data);
		$qr->execute();
		
		return $qr;
	}
	
	function selecionarAtualizacao(){
		$sql = self::conectar();
		
		$select = 'select * from tb_atualizacoes order by id desc limit 30';
		
		$qr = $sql->query($select);
		return $qr;
	}
	
	//configs sites
	function editarConfig($img, $nomeDepartamento, $cor){
		$sql = self::conectar();
		
		$novaCor = $cor;
		$novaCor = str_replace('#', '', $novaCor);
		
		$qr = $sql->prepare("update tb_config set img = ?, nomeDepartamento = ?, cor = ? where id = 1");
		$qr->bind_param('sss',$img, $nomeDepartamento, $novaCor);
		
		$qr->execute();
		return $qr;
	}
	
	function selecionarConfig(){
		$sql = self::conectar();
		
		$select = 'select * from tb_config';
		
		$qr = $sql->query($select);
		return $qr;
	}
	
	function corConfig(){
		$sql = self::conectar();
		
		$qr = $sql->prepare('select cor from tb_config');
		$qr->execute();
		
		return $qr->get_result();
	}
	
	
	function gerarData(){
		$data = date("D/d/m/Y");
		$data = explode('/', $data);
		
		//define dias da Semana
		if($data[0] == "Mon"){
			$data[0] = "Segunda";
		}else if($data[0] == "Tue"){
			$data[0] = "Terca";
		}else if($data[0] == "Wed"){
			$data[0] = "Quarta";
		}else if($data[0] == "Thu"){
			$data[0] = "Quinta";
		}else if($data[0] == "Fri"){
			$data[0] = "Sexta";
		}else if($data[0] == "Sat"){
			$data[0] = "Sabado";
		}else if($data[0] == "Sun"){
			$data[0] = "Domingo";
		}
		$data[2] == "11";
		//define meses do ano
		if($data[2] == "01"){
			$data[2] = "Janeiro";
		}else if($data[2] == "02"){
			$data[2] = "Fevereiro";
		}else if($data[2] == "03"){
			$data[2] = "Marco";
		}else if($data[2] == "04"){
			$data[2] = "Abril";
		}else if($data[2] == "05"){
			$data[2] = "Maio";
		}else if($data[2] == "06"){
			$data[2] = "Junho";
		}else if($data[2] == "07"){
			$data[2] = "Julho";
		}else if($data[2] == "08"){
			$data[2] = "Agosto";
		}else if($data[2] == "09"){
			$data[2] = "Setembro";
		}else if($data[2] == "10"){
			$data[2] = "Outubro";
		}else if($data[2] == "11"){
			$data[2] = "Novembro";
		}else if($data[2] == "12"){
			$data[2] = "Dezembro";
		}

		$dataFormatada = $data[0].', '. $data[1] . ' de ' . $data[2] . ' de ' . $data[3];
		return $dataFormatada;
	}
	
	//paginacao 
	function nRegistro($tabela){
		$sql = self::conectar();
		
		$select = "select id from $tabela where visualizacao = 1";
		$qr = $sql->query($select);
		
		$ntotal = mysqli_num_rows($qr);
		return $ntotal;
	
	}
	

	
} 


?>