# saraiva

Ferramentas utilizadas:

Spring Boot;
Spring Rest;
Spring JPA;
JAVA 8;
Banco de Dados H2;

Funcionamento:

Importar um projeto Spring Boot e gerar um .jar.
O servidor irá executar na porta 8080.

Para listar todos os livros cadastrados:
http://localhost:8080/book/

Retorna o numero de livros passados no parametro "limit".
http://localhost:8080/book/?limit=2

Retorna livros com valor igual ou inferior ao valor passado ao parametro "price".
http://localhost:8080/book/?price=37

GET - Retorna o livro conforme o sku informado.
http://localhost:8080/book/xxx

DELETE - Deleta o livro conforme o sku informado.
http://localhost:8080/book/xxx

POST - Insere o livro conforme corpo json enviado.
http://localhost:8080/book/

Pendencias:
Devido a compromissos pessoais, o WS da Saraiva foi consumido e não persistido no banco de dados.
Para mostrar o correto consumo, está sendo impresso no console no momento que a aplicação é iniciada.

Observacoes:
O banco de dados H2 é um banco de dados relacional em memoria, a cada inicializacao da aplicacao, seus dados seu resetados.

Deixo meu github a disposicao para verificar outros projetos pessoas: https://github.com/joaofel/

Obrigado.
