var cabecalho = document.getElementById("cabecalho");

if (cabecalho.attachEvent) {
  cabecalho.attachEvent("onclick", function (event) {
    alert("Você clicou no cabeçalho, usuário do IE!");
  });
} else if (cabecalho.addEventListener) {
  cabecalho.addEventListener("click", function (event) {
    alert("Você clicou no cabeçalho!")
  }, false);
}