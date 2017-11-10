<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de usu&aacute;rios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Rede Social</title>
		<link rel="shortcut icon" href="Img/logo.ico" type="x-icon">
    </head>
    <body>
        ${mensagem}
		<!-- CSS -->
			<style rel="stylesheet" type="text/css">
			.pag{
				width:100%;
				height:100%;
				position:absolute;
				background-color:#DDA0DD;
				
				display:flex;
				justify-content:center;
				align-items:center;
			}
			
			.log { width:300px;text-align:left;height:325px; font-family:arial;!important; margin:0px;background-color:#9370DB;}
			.log input[type="text"]{padding:3px;font-size; 10px !important; margin:10px; width:100%; font-size:10px;}
			.log input[type="password"]{padding:3px;font-size; 10px !important; margin:0px 3px; width:100%; font-size:10px;}
			}
			
			body{
				padding:0;
				margin:0;
			}
			
			.pag .box #cadastro{ width:300px;text-align:left; font-family:arial; font-size; 10px !important; margin:2px;background-color:#BA55D3;}
			.pag .box #cadastro input[type="text"]{padding:3px;font-size; 10px !important; margin:8px; width:95%; font-size:10px;}
			
			</style>
		<!--------->
		
        <div class="pag">
			<div class="box">
			<!--Box cadastro-->
				<form id="cadastro" action="UsuarioControle?operacao=Cadastrar" method="post">
				<h1>Ainda não possui uma Conta?</h1>
					<input type="text" name="nome" value="" id="nome" placeholder="Nome" />
					<br />
					<input type="text" name="sobrenome" value="" id="nome" placeholder="Sobrenome" />
					<br />
					<input type="text" name="email" value="" id="email" placeholder="E-mail"/>
					<br />	
					<center>
					 <select name="dataNasc">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select>
					<select name="mesNasc">
						<option value="1">Janeiro</option>
						<option value="2">Fevereiro</option>
						<option value="3">Março</option>
						<option value="4">Abril</option>
						<option value="5">Maio</option>
						<option value="6">Junho</option>
						<option value="7">Julho</option>
						<option value="8">Agosto</option>
						<option value="9">Setembro</option>
						<option value="10">Outubro</option>
						<option value="11">Novembro</option>
						<option value="12">Dezembro</option>
					</select>
					<select name="anoNasc">
					<option value="1997">1997</option>
					</select>
					</center>
					<br />
					<h5>
					<input type="checkbox" value="termosAceitos" /> Aceito os 
					<a href="termos.html">termos de uso<a/>
					</h5>
					<input type="submit" value="Criar conta"/>
				</form>
			<!----------->
			</div>
			<div class="log">
			<center>
			<img src=""height="100px"width="100px"/>
			<br />
			<input type="text" name="email" value="" id="email" placeholder="E-mail ou Username"/>
			<br />
			<input type="password" name="senha" value="" id="senha" placeholder="Senha"/>
			<br />
			<input type="submit" value="Entrar"/>
			</center>
			</div>
		</div>	
    </body>
</html>
