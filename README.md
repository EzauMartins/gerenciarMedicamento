# Gerenciador de Medicamento

-----------------------------------------------------------
Projeto BootCamp Everis DigitalInnovationONE
-----------------------------------------------------------

Projeto - Com intuito de concluir modulo do bootcamp, e demostrar aprendizado da trilha.

/////////////////////////////////////////////////////////////

Dependencias:
Spring Web - DevTools - Lombok  - Banco H2 - Mapper

Construção:
A API a principio possue duas entidades, onde uma se refere ao medicamento
contendo suas informações como: (nome,tarja,codigo de barra e tipo)
Onde TIPO  é uma segunda entidade com o objetivo de informar o estado do medicamento:
EX(CAPSULA,COMPRIMIDO,LIQUIDO) e sua medida. EX(ml,litro,Unidade,peso)

Execução:
Possue os metodos principais, POST,GET,PUT e DELETE.
As entidades ultilizam copias DTO para o auxilio no controle de validação.



