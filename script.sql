DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'clientes') THEN
        CREATE TABLE clientes (
            id SERIAL PRIMARY KEY,
            nome VARCHAR(100),
            limite INT NOT NULL,
            saldo INT NOT NULL
        );
    END IF;

    IF NOT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'transacoes') THEN
        CREATE TABLE transacoes (
            id SERIAL PRIMARY KEY,
            cliente_id INT NOT NULL,
            valor INT NOT NULL,
            tipo CHAR(1) CHECK (tipo IN ('c', 'd')),
            descricao VARCHAR(10) NOT NULL,
            realizada_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE
        );
    END IF;

    IF NOT EXISTS (SELECT 1 FROM clientes) THEN
        INSERT INTO clientes (nome, limite, saldo) VALUES
        ('Cliente 1', 1000, 0),
        ('Cliente 2', 500, 0),
        ('Cliente 3', 2000, 0),
        ('Cliente 4', 1500, 0),
        ('Cliente 5', 750, 0);
    END IF;
END $$;