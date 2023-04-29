# LABMEDICALBD・Projeto Final・Módulo Back-End・DiP
## Introdução
Este é o segundo e último projeto do segundo módulo do curso DEVinHouse, turma Philips. Ele é um sucessor espiritual do projeto final do módulo de frontend, e juntos formariam minha primeira aplicação full-stack.

### Motivação
A fim de acelerar o atendimento de pacientes, o sistema LabMedical permite que médicos loguem no sistema e cadastrem pacientes, assim como consultas e exames. Na medicina, essa prática de registrar os exames e consultas é conhecida como "evoluir o paciente". Agilizar esse trabalho burocrático e reduzir erros validando os dados enviados melhora a produtividade dos médicos, e permitem que eles façam mais do seu trabalho, que é cuidar da saúde dos pacientes.

### Escopo
O módulo de back-end é responsável por validar as informações enviadas pelo front-end, salvá-las, e também por retornar os dados buscados pelo front-end. Ele é uma API Rest nível 2 integrada com banco de dados Oracle. Existem serviços ligados a usuários (médicos), pacientes, consultas, exames, endereços, e estatísticas. A maioria dos serviços apresenta todas as funcionalidades de um CRUD.

## Detalhes Técnicos
### Tecnologia utilizada
A linguagem utilizada foi Java. Foram utilizados Spring, incluindo Spring Boot, Data, MVC, e Validation. Além disso, foi utilizado Lombok e MapStruct para agilizar a construção de DTOs. O desenvolvimento foi realizado na IDE IntelliJ Ultimate. Para o banco de dados, foi utilizado o PL/SQL, com o SQL Developer. Para o envio de requisições para teste, foi usado o Insomnia. Por fim, mas não menos importante, foi utilizado o Github para versionamento.

### Técnicas utilizadas
O projeto foi dividido em camadas. A camada de RestController faz uma validação de DTOs de requisição a partir de annotations e os direciona para a de Service. Esta, por sua vez, realiza a lógica de negócio e transforma o DTO de requisição em uma Entity pronta para ser enviada para o Repository, e faz o envio. A camada de Repository é responsável por interagir com o banco de dados e devolver a resposta ao Service. É feita uma nova transformação de entidade para DTO de resposta, que é devolvido para o RestController, que envia para o usuário. Quando a requisição é utiliza o método GET, é feita apenas a transformação da entidade vinda do repositório para DTO de resposta.

As transformações de DTO e entidade foram agilizadas por meio do framework MapStruct, mas foi necessário customizar alguns detalhes, de forma que ele pode ser removido das dependências do programa sem prejuízo.

Para agilizar e facilitar os testes, foi desenvolvido um script de SQL para popular o banco de dados com seeders para cada tabela.

### Planejamento de branches
O projeto foi separado em algumas branches, desenvolvidas na seguinte ordem:
1. Controllers: foram criados os controllers com os endpoints conforme especificações do projeto. Não havia necessidade de saber como nada seria feito, apenas direcionar para um método com nome adequado no service;
2. Models: foram criadas as entidades e DTOs de requisição e resposta, uma vez que já ficou evidente na assinatura dos métodos do controller o que seria necessário;
3. Repositories: tendo as entidades prontas, a criação de repositórios foi trivial;
4. Services: finalmente essa "cola" entre o controller e o repository foi feita com os services;
5. Refactor: aqui acertei os detalhes (como funciona Lombok com MapStruct? como configura o bd Oracle? etc, etc)

### Como executar
Para rodar o programa, é necessário baixar tudo, abrir na sua IDE favorita, e pegar todas as dependências do `pom.xml` com o Maven. Depois disso, é necessário configurar o arquivo `application.properties` com o caminho para o seu banco de dados, assim como usuário e senha. Normalmente, basta trocar o final do caminho de `labmedicalbd`para `xe`, que é o nome padrão dos bancos de dados. Esse arquivo está configurado para apagar todas as tabelas e criar novas tabelas a cada execução. Se quiser mudar essa configuração, a opção do `spring.jpa.hibernate.ddl-auto` deve ser trocada de `create` para `update`, e OU o arquivo `data.sql` deve ser removido/renomeado para não inserir registros duplicados no banco de dados, OU a opção `spring.sql.init.mode=always` pode ser removida. Ambos estão na pasta `resources`. Feito isso, é só rodar a aplicação na IDE.

Uma vez que a aplicação está rodando, é possível testar com algum programa que envie requisições http. Na raiz do projeto, na pasta `postman`, tem um arquivo `.json` com testes para todos os endpoints da aplicação.

### Melhorias
As validações do programa são relativamente simples, aplicando a regra de negócio de que CPFs são únicos, alguns campos são obrigatórios, datas seguem um formato específico, assim como e-mail e CPF. Poderiam ser feitas validações mais sofisticadas, como formato padronizado de telefone, etc. Alguns endpoints facilitariam o uso da aplicação, como buscar consultas e exames por paciente. Poderia ser incluído autenticação de médico.

## Agradecimentos
Não poderia deixar de agradecer ao Senai-SC, LAB365, e à Philips pela curso disponibilizado gratuitamente. Em uma nota mais pessoal, sou grato pelas aulas com os professores André Nunes, que acompanhou todo o módulo, e João Vitor, que ensinou PL/SQL e Spring.
