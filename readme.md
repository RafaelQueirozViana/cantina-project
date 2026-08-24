# API da Cantina Escolar

Criei essa API REST para resolver um problema real de um sistema de caixa: antes, qualquer mudança no cardápio de lanches exigia mexer direto no código-fonte. Com essa API, o gerenciamento do catálogo ficou dinâmico e o sistema da cantina consegue gerenciar os produtos atualizados em tempo real.

O foco principal foi desenvolver uma aplicação prática que resolvesse o fluxo completo de CRUD (cadastro, listagem, busca por ID, atualização e exclusão de lanches), garantindo o retorno correto dos status HTTP e respostas limpas em JSON.

## Como estruturei o projeto

Para deixar o código organizado e fácil de manter, usei o padrão de arquitetura em camadas:
* Controller: Onde ficam os endpoints e a entrada das requisições.
* Service: Onde coloquei as regras de negócio e validações.
* Repository: A parte que cuida da comunicação com o banco de dados.

Também adicionei validações para garantir que nenhum lanche seja cadastrado com dados faltando e fiz o tratamento de erros para que a API não quebre caso alguém busque um ID que não existe. Todo o progresso foi salvo passo a passo usando Git.

## Ferramentas que usei

* Java - Linguagem base do projeto.
* Spring Boot - Para subir a aplicação de forma rápida e configurar os serviços REST.
* Spring Data JPA - Para facilitar a escrita das consultas e manipulação dos dados.
* Bean Validation - Para validar os campos obrigatórios (nome, descrição e preço).
* MySQL - Banco de dados relacional para salvar as informações dos lanches.
* Git e GitHub - Para o controle de versão do código.
