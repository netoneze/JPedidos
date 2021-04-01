DROP TABLE IF EXISTS usuario;

CREATE table usuario (
    login VARCHAR(45) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(45) NOT NULL,
    tipo('administrador', 'gerente', 'funcionario') NOT NULL,
    PRIMARY KEY(login)
);

DROP TABLE IF EXISTS pedido;

CREATE table pedido (
    idPedido INT NOT NULL AUTO_INCREMENT,
    nomeCliente VARCHAR(100) NOT NULL,
    telefoneCliente VARCHAR(10) NOT NULL,
    valorTotal FLOAT(10,2) NOT NULL,
    login VARCHAR(45) NOT NULL,
    PRIMARY KEY(idPedido),
    FOREIGN KEY(login) REFERENCES usuario(login)
);

DROP TABLE IF EXISTS produto;

CREATE table produto(
    nome VARCHAR(30) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    precoUnid FLOAT(10,2) NOT NULL,
    PRIMARY KEY(nome)
);

DROP TABLE IF EXISTS order_product;

CREATE table pedido_has_produto(
    pedido_idPedido INT NOT NULL,
    produto_nome VARCHAR(30) NOT NULL,
    quantidade INT NOT NULL,
    FOREIGN KEY(pedido_idPedido) REFERENCES pedido(idPedido),
    FOREIGN KEY(produto_nome) REFERENCES produto(nome)
);

INSERT INTO usuario (nome, login, senha, email, tipo) VALUES ("administrador","admin","admin456","admin@hotmail.com","administrador");
INSERT INTO usuario (nome, login, senha, email, tipo) VALUES ("gerente","gerente","gerente456","gerente@hotmail.com","gerente");
INSERT INTO usuario (nome, login, senha, email, tipo) VALUES ("usuario","usuario","usuario456","usuario@hotmail.com","funcionario");
INSERT INTO pedido (idPedido, nomeCliente, telefoneCliente, login, valortotal) VALUES (1,"Cleyton", "(11)66666-6666","cleiton", 333.66);
INSERT INTO produto (nome, descricao, precoUnid) VALUES ("Produto 3", "O produto 3 possui a seguinte descrição", 111.99);