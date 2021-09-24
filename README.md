# Gerenciador de Medicamento

Projeto BootCamp Everis DigitalInnovationONE
-----------------------------------------------------------

Projeto com intuito de concluir modulo do bootcamp, e demostrar aprendizado da trilha.

-----------------------------------------------------------

Dependencias Ultilizadas:<br />
Spring Web - DevTools - Lombok  - Banco H2 - mapstruct

Construção:<br />
A API a principio possui duas entidades, onde uma se refere ao medicamento<br />
contendo suas informações como: (nome,tarja,codigo de barra e tipo)<br />
Onde TIPO  é uma segunda entidade com o objetivo de informar o estado do medicamento:<br />
EX(CAPSULA,COMPRIMIDO,LIQUIDO) e sua medida. EX(ml,litro,Unidade,peso)<br />

Execução:<br />
Possue os metodos principais, POST,GET,PUT e DELETE.<br />
As entidades ultilizam copias DTO para o auxilio no controle de validação.<br />
Banco H2 um banco em memória para agilidade dos testes.

Exemplo de estrutura do JSON para POST na API:<br /><br />
{<br />
	"name": "Dipirona",<br />
	"tarja": "Branca",<br />
	"codBar": "1234567891012",<br />
	"tipo":[<br />
		{<br />
			"tipoMed": "capsula",<br />
			"medida": "und"<br />
		}<br />
	]	<br />
}<br />

