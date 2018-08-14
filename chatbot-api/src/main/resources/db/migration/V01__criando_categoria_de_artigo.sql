CREATE TABLE IF NOT EXISTS article_category (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL
);

INSERT INTO article_category(name) VALUES ('Arquitetura'), ('Decoração'),
('Sustentabilidade'), ('Paisagismo');