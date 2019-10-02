--criando tabela tb_categoria
CREATE TABLE tb_categoria(
	id SERIAL PRIMARY KEY,
	nome varchar(50)
);

--criando tabela tb_categoria
CREATE TABLE tb_produto(
	id SERIAL PRIMARY KEY,
	id_categoria integer NOT NULL,
	nome varchar(80),
	valorunitario double precision,
	CONSTRAINT fk_produto_categoria FOREIGN KEY (id_categoria) 
		REFERENCES tb_categoria(id)
);

INSERT INTO tb_categoria (id,nome) VALUES (1,'Informática');
INSERT INTO tb_categoria (id,nome) VALUES (2,'Eletrônicos');
INSERT INTO tb_categoria (id,nome) VALUES (3,'Papelaria');
INSERT INTO tb_categoria (id,nome) VALUES (4,'Beleza');
INSERT INTO tb_categoria (id,nome) VALUES (5,'Livros');
INSERT INTO tb_categoria (id,nome) VALUES (6,'Perfumaria');
INSERT INTO tb_categoria (id,nome) VALUES (7,'Móveis');
INSERT INTO tb_categoria (id,nome) VALUES (8,'Celulares');

--INSERT INTO tb_categoria (nome) VALUES ('Informática');
--INSERT INTO tb_categoria (nome) VALUES ('Eletônicos');
--INSERT INTO tb_categoria (nome) VALUES ('Papelaria');
--INSERT INTO tb_categoria (nome) VALUES ('Beleza');
--INSERT INTO tb_categoria (nome) VALUES ('Livros');
--INSERT INTO tb_categoria (nome) VALUES ('Perfumaria');
--INSERT INTO tb_categoria (nome) VALUES ('Móveis');
--INSERT INTO tb_categoria (nome) VALUES ('Celulares');