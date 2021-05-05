DROP DATABASE IF EXISTS oficina2;
CREATE DATABASE oficina2;
USE oficina2;

DROP TABLE IF EXISTS usuario;

CREATE table usuario (
    usuarioid INT NOT NULL AUTO_INCREMENT,
    login VARCHAR(45) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(45) NOT NULL,
    tipo ENUM('administrador', 'gerente', 'funcionario') NOT NULL,
    PRIMARY KEY(usuarioid)
);

DROP TABLE IF EXISTS pedido;

CREATE table pedido (
    idPedido INT NOT NULL AUTO_INCREMENT,
    nomeCliente VARCHAR(100) NOT NULL,
    telefoneCliente VARCHAR(20) NOT NULL,
    valorTotal FLOAT(10,2) NOT NULL,
    pedidoStatus ENUM('aberto', 'fechado'),
    usuarioid INT NOT NULL,
    criadoEm DATETIME NOT NULL,
    fechadoEm DATETIME,
    PRIMARY KEY(idPedido),
    FOREIGN KEY(usuarioid) REFERENCES usuario(usuarioid) 
);

DROP TABLE IF EXISTS produto;

CREATE table produto(
    produtoId INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    precoUnid FLOAT(10,2) NOT NULL,
    PRIMARY KEY(produtoId)
);

DROP TABLE IF EXISTS order_product;

CREATE table pedido_has_produto(
    pedido_idPedido INT NOT NULL,
    produto_id INT NOT NULL,
    quantidade_produto INT NOT NULL,
    FOREIGN KEY(pedido_idPedido) REFERENCES pedido(idPedido),
    FOREIGN KEY(produto_id) REFERENCES produto(produtoId) ON DELETE CASCADE
);

INSERT INTO usuario (nome, login, senha, email, tipo) VALUES ("administrador","admin","admin456","admin@hotmail.com","administrador");
INSERT INTO usuario (nome, login, senha, email, tipo) VALUES ("gerente","gerente","gerente456","gerente@hotmail.com","gerente");
INSERT INTO usuario (nome, login, senha, email, tipo) VALUES ("usuario","usuario","usuario456","usuario@hotmail.com","funcionario");
INSERT INTO pedido (idPedido, nomeCliente, telefoneCliente, usuarioid, valortotal) VALUES (1,"Cleyton", "(11)66666-6666", 3, 333.66);
INSERT INTO produto (nome, descricao, precoUnid) VALUES ("Produto 3", "O produto 3 possui a seguinte descrição", 111.99);
