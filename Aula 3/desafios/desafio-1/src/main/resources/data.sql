-- Script para inserir dados de exemplo no banco H2
-- Os dados serão carregados automaticamente quando a aplicação iniciar

-- Inserindo contatos
INSERT INTO contacts (nome, telefone, email) VALUES 
('João Silva', '9999-9999', 'joao@email.com'),
('Maria Santos', '8888-8888', 'maria@email.com'),
('Pedro Costa', '7777-7777', 'pedro@email.com'),
('Ana Oliveira', '6666-6666', 'ana@email.com'),
('Carlos Pereira', '5555-5555', 'carlos@email.com');

-- Inserindo endereços (associados aos contatos)
INSERT INTO addresses (rua, cidade, estado, cep, contact_id) VALUES 
('Rua das Flores, 123', 'São Paulo', 'SP', '01234-567', 1),
('Avenida Paulista, 1000', 'São Paulo', 'SP', '01310-100', 1),
('Rua Copacabana, 456', 'Rio de Janeiro', 'RJ', '22000-000', 2),
('Rua Ipanema, 789', 'Rio de Janeiro', 'RJ', '22400-000', 2),
('Rua do Sol, 321', 'Belo Horizonte', 'MG', '30112-000', 3),
('Avenida Afonso Pena, 2000', 'Belo Horizonte', 'MG', '30130-000', 4),
('Rua da Liberdade, 654', 'Salvador', 'BA', '40000-000', 5);
