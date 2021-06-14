# JPedidos
Sistema fictício para controle de pedidos em Java.

Desenvolvido para a disciplina de Oficina de Integração 2, ministrada pelo professor Dr. André Takeshi Endo, do curso de Engenharia de Software da UTFPR de Cornélio Procópio.

Fork criado por Nelson Toneze e Yohan Pessanha.

## Requisitos técnicos obrigatórios utilizados
- Linguagem de programação Java
- Banco de dados MySQL
- GUI Desktop usando Java Swing
- Testes de unidade com JUnit 5
    - 75% de line coverage
- No frameworks policy: Apenas frameworks permitidos pelo professor.

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


## Capturas de Tela

- Algumas printscreens do sistema:

![login](https://user-images.githubusercontent.com/30937322/121937739-6100f680-cd21-11eb-8de3-26878e90360b.png)

![funcionario_home](https://user-images.githubusercontent.com/30937322/121937767-678f6e00-cd21-11eb-9cc8-18ce437c7b4e.png)

![funcionario_pedido](https://user-images.githubusercontent.com/30937322/121937796-70803f80-cd21-11eb-955f-487356eb94fd.png)

![admin_home](https://user-images.githubusercontent.com/30937322/121937809-74ac5d00-cd21-11eb-9e1c-4040d284135e.png)




