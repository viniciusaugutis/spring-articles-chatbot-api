INSERT INTO topic (name, description, meta, article_category_id) VALUES 
('projeto de interiores', 'projeto de interiores descrição', null, 2),
('banheira, spa e ofurô', 'banheiro, spa e ufurô descrição', null, 2);

INSERT INTO question (name, is_valid, meta, topic_id) VALUES
('Por que é tão importante um projeto de interiores?', 'true', null, 1),
('Estilo de decoração clean, quando e como surgiu?', 'true', null, 1),
('Quais são as características de estilo de decoração clean?', 'true', null, 1),
('Quais cuidados tomar ao escolher o estilo de decoração clean?', 'true', null, 1);

INSERT INTO question (name, is_valid, meta, topic_id) VALUES
('Vale a pena ter uma banheira em casa?', 'true', null, 2),
('Qual a diferença entre banheira, spa e ofurô?', 'true', null, 2),
('Como escolher a ideal e o que devo levar em consideração?', 'true', null, 2),
('Como são instaladas?', 'true', null, 2),
('Como é a manutenção desses equipamentos? ', 'true', null, 2);