CREATE TABLE produto(
id_produto SERIAL PRIMARY KEY,
nome_produto VARCHAR(100),
quantidade DOUBLE PRECISION,
cod_unidade int REFERENCES unidades (id_unidade),
preco_unitario DOUBLE PRECISION
);
CREATE TABLE unidades(
id_unidade SERIAL PRIMARY KEY,
cigla VARCHAR (5),
unidade VARCHAR(50)
);

SELECT * FROM unidades;
SELECT * FROM produtos;

