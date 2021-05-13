# JPedidos
Sistema fictício para controle de pedidos em Java.

Desenvolvido para a disciplina de Oficina de Integração 2, ministrada pelo professor Dr. André Takeshi Endo, do curso de Engenharia de Software da UTFPR de Cornélio procópio.

Fork criado por Nelson Toneze e Yohan Pessanha.

## Requisitos técnicos obrigatórios utilizados
- Linguagem de programação Java
- Banco de dados MySQL
- GUI Desktop usando Java Swing
- Testes de unidade com JUnit 5 e Mockito
    - 90% de line coverage
- No frameworks policy: o projeto não deve incluir muitas dependências, salvo as autorizadas.

## Tipos de usuário

- Admin: função única de adicionar novos usuários.

- Gerente: cadastrar/alterar produtos, listar os pedidos.

- Funcionário: cadastrar um novo pedido. 

## Estórias de usuário aplicadas

- E1 - Realizar login

Como um usuário, eu quero logar no sistema para acessar minhas funcionalidades no sistema de pedidos.

- E2 - Fazer pedido

Como um funcionário, eu quero registrar um pedido com produtos para passar a equipe, informar o valor total e atender ao cliente.

- E3 - Adicionar usuário

Como um admin, eu quero inserir, atualizar e remover usuários de diferentes tipos. 

- E4 - Cadastrar produto

Como um gerente, eu quero inserir, atualizar e remover produtos para que possam ser vendidos aos clientes.

- E5 - Listar pedidos

Como um gerente e funcionário, eu quero listar os pedidos para acompanhar as vendas. 

- E6 - Fechar pedido

Como um funcionário, eu quero fechar um pedido para registrar que o pedido foi entregue ao cliente.

- E10 - Fazer pedido de pacote

Como um funcionário, eu quero registrar um pedido pré-definido para passar a equipe, informar o valor total e atender ao cliente.


## Regras de negócio

- Usuário: possui nome completo, login, senha, e-mail e é de um único tipo (ver tipos de usuários). 

- Produto: possui nome curto, descrição e preço unitário. 

- Pedido: possui o nome e telefone do cliente, e contém um ou mais produtos associados. Cada produto tem uma quantidade de no mínimo 1 (um). O valor total do pedido deve ser calculado. 
