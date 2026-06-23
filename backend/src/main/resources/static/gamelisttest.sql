--
-- PostgreSQL schema and seed data for database "gamelist"
-- Converted from the original MySQL dump.
--

-- ---------------------------------------------------------------------------
-- Drop existing tables
-- ---------------------------------------------------------------------------

DROP TABLE IF EXISTS plataforma_de_jogo CASCADE;
DROP TABLE IF EXISTS modo_de_jogo CASCADE;
DROP TABLE IF EXISTS genero_do_jogo CASCADE;
DROP TABLE IF EXISTS jogo_adicionado CASCADE;
DROP TABLE IF EXISTS avaliacao CASCADE;
DROP TABLE IF EXISTS jogo CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS plataforma CASCADE;
DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS modo CASCADE;
DROP TABLE IF EXISTS lista CASCADE;
DROP TABLE IF EXISTS genero CASCADE;
DROP TABLE IF EXISTS distribuidora CASCADE;
DROP TABLE IF EXISTS desenvolvedora CASCADE;

-- ---------------------------------------------------------------------------
-- Table structure (primary keys and unique constraints only;
-- foreign keys are added at the end to avoid creation-order issues)
-- ---------------------------------------------------------------------------

CREATE TABLE desenvolvedora (
  id_desenvolvedora SERIAL PRIMARY KEY,
  nm_desenvolvedora varchar(100) NOT NULL,
  CONSTRAINT nm_desenvolvedora_unique UNIQUE (nm_desenvolvedora)
);

CREATE TABLE distribuidora (
  id_distribuidora SERIAL PRIMARY KEY,
  nm_distribuidora varchar(100) NOT NULL,
  CONSTRAINT nm_distribuidora_unique UNIQUE (nm_distribuidora)
);

CREATE TABLE genero (
  id_genero SERIAL PRIMARY KEY,
  nm_genero varchar(100) NOT NULL,
  CONSTRAINT nm_genero_unique UNIQUE (nm_genero)
);

CREATE TABLE lista (
  id_lista SERIAL PRIMARY KEY,
  nm_lista varchar(45) NOT NULL
);

CREATE TABLE modo (
  id_modo SERIAL PRIMARY KEY,
  nm_modo varchar(100) NOT NULL,
  CONSTRAINT nm_modo_unique UNIQUE (nm_modo)
);

CREATE TABLE permissao (
  id_permissao SERIAL PRIMARY KEY,
  nm_permissao varchar(255) DEFAULT NULL,
  CONSTRAINT nm_permissao_unique UNIQUE (nm_permissao)
);

CREATE TABLE plataforma (
  id_plataforma SERIAL PRIMARY KEY,
  nm_plataforma varchar(100) NOT NULL,
  CONSTRAINT nm_plataforma_unique UNIQUE (nm_plataforma)
);

CREATE TABLE usuario (
  id_usuario SERIAL PRIMARY KEY,
  id_permissao integer NOT NULL,
  nm_username varchar(255) DEFAULT NULL,
  nm_apelido varchar(255) DEFAULT NULL,
  ds_email varchar(255) DEFAULT NULL,
  ds_senha varchar(255) DEFAULT NULL,
  nr_telefone varchar(20) DEFAULT NULL,
  dt_nascimento date DEFAULT NULL,
  CONSTRAINT ds_email_unique UNIQUE (ds_email),
  CONSTRAINT nm_username_unique UNIQUE (nm_username),
  CONSTRAINT nm_apelido_unique UNIQUE (nm_apelido),
  CONSTRAINT nr_telefone_unique UNIQUE (nr_telefone)
);

CREATE TABLE jogo (
  id_jogo SERIAL PRIMARY KEY,
  id_distribuidora integer NOT NULL,
  id_desenvolvedora integer NOT NULL,
  nm_jogo varchar(200) NOT NULL,
  ds_sinopse text NOT NULL,
  dt_lancamento date NOT NULL,
  ds_imagem varchar(255) NOT NULL,
  nr_total_nota numeric(3,1) DEFAULT NULL,
  CONSTRAINT nm_jogo_unique UNIQUE (nm_jogo),
  CONSTRAINT ds_imagem_unique UNIQUE (ds_imagem)
);

CREATE TABLE avaliacao (
  id_avaliacao SERIAL PRIMARY KEY,
  id_jogo integer NOT NULL,
  id_usuario integer NOT NULL,
  tx_comentario text DEFAULT NULL,
  nr_usuario_nota numeric(3,1) NOT NULL,
  dt_comentario date DEFAULT NULL,
  dt_envio varchar(45) NOT NULL
);

CREATE TABLE genero_do_jogo (
  id_jogo integer NOT NULL,
  id_genero integer NOT NULL,
  PRIMARY KEY (id_jogo, id_genero)
);

CREATE TABLE modo_de_jogo (
  id_jogo integer NOT NULL,
  id_modo integer NOT NULL,
  PRIMARY KEY (id_jogo, id_modo)
);

CREATE TABLE plataforma_de_jogo (
  id_plataforma integer NOT NULL,
  id_jogo integer NOT NULL,
  PRIMARY KEY (id_plataforma, id_jogo)
);

CREATE TABLE jogo_adicionado (
  id_lista integer NOT NULL,
  id_usuario integer NOT NULL,
  id_jogo integer NOT NULL
);

-- ---------------------------------------------------------------------------
-- Data
-- ---------------------------------------------------------------------------

INSERT INTO desenvolvedora VALUES (32,' Konami'),(23,' Krafton'),(87,'11 bit studios'),(31,'2K Sports'),(2,'Afterthought LLC'),(68,'Amanita Design'),(54,'Arc System Works'),(90,'Arkane Studios'),(94,'Asmodee Digital'),(59,'Avalanche Studios'),(42,'Behaviour Interactive'),(16,'BioWare'),(25,'Blizzard Entertainment'),(43,'Bloober Team'),(75,'Brogue Devs'),(37,'Bungie'),(34,'Campo Santo'),(40,'Capcom'),(7,'CD Projekt Red'),(78,'Cellar Door Games'),(60,'Chucklefish'),(89,'CI Games'),(88,'Deck13 Interactive'),(48,'Devolver Digital'),(26,'Dire Wolf Digital'),(21,'Dontnod Entertainment'),(72,'DotEmu'),(8,'EA Vancouver'),(74,'Edmund McMillen'),(86,'Endnight Games'),(5,'Epic Games'),(79,'Facepunch Studios'),(30,'Filimundus'),(93,'Frictional Games'),(4,'FromSoftware'),(84,'Frontier Developments'),(65,'Gears for Breakfast'),(83,'Giants Software'),(102,'Haemimont Games'),(35,'Hello Games'),(98,'Hidden Path Entertainment'),(76,'Hopoo Games'),(52,'Humongous Entertainment'),(45,'Hyper Hippo Games'),(36,'id Software'),(38,'Infinity Ward'),(11,'InnerSloth'),(64,'Insomniac Games'),(62,'Inti Creates'),(92,'IO Interactive'),(24,'Iron Galaxy Studios'),(96,'Ironhide Game Studio'),(80,'Keen Software House'),(85,'Klei Entertainment'),(91,'Kojima Productions'),(17,'Larian Studios'),(28,'LeapFrog'),(66,'LucasArts'),(82,'Maxis'),(101,'MicroProse'),(6,'Mojang Studios'),(73,'Motion Twin'),(14,'Naughty Dog'),(53,'NetherRealm Studios'),(97,'Ninja Kiwi'),(39,'Ninja Theory'),(3,'Nintendo EPD'),(95,'Nomad Games'),(18,'Obsidian Entertainment'),(46,'Orteil'),(29,'Osmo'),(51,'Outright Games'),(15,'PlatinumGames'),(63,'Playdead'),(27,'PlayFusion'),(44,'Playsaurus'),(77,'Poncle'),(69,'PopCap Games'),(22,'PUBG Corporation'),(20,'Quantic Dream'),(81,'Re-Logic'),(41,'Red Barrels'),(99,'Remedy Entertainment'),(12,'Respawn Entertainment'),(13,'Rockstar Games'),(428,'Rockstar North'),(427,'Rockstar Studios'),(9,'Santa Monica Studio'),(55,'SNK Corporation'),(56,'Square Enix'),(10,'Supergiant Games'),(47,'Team Cherry'),(33,'Team Ninja'),(19,'Telltale Games'),(1,'TesteDesenvolvedora'),(71,'Thekla Inc'),(100,'Third Wire'),(50,'Toca Boca'),(61,'Tribute Games'),(58,'Ubisoft'),(67,'Wadjet Eye Games'),(49,'Yacht Club Games'),(70,'Zachtronics'),(57,'ZeniMax Online Studios');

INSERT INTO distribuidora VALUES (72,'2K Games'),(41,'505 Games'),(47,'Activision'),(2,'Afterthought LLC'),(80,'Asmodee Digital'),(4,'Bandai Namco Entertainment'),(79,'BANDAI NAMCO Entertainment America'),(33,'Bandai Namco Entertainment Europe'),(46,'Bethesda Softworks'),(51,'Capcom'),(7,'CD Projekt'),(55,'CD Projekt Red'),(77,'Codemasters'),(78,'Curve Digital'),(37,'Deep Silver'),(38,'Devolver Digital'),(8,'Electronic Arts'),(63,'Electronic Arts Inc.'),(5,'Epic Games'),(56,'Focus Entertainment'),(39,'Focus Home Interactive'),(43,'Gearbox Publishing'),(11,'InnerSloth'),(73,'Kalypso Media'),(42,'Koch Media'),(45,'Konami Digital Entertainment'),(58,'Larian Studios'),(66,'Marvelous'),(60,'Microsoft Studios'),(52,'Nexon'),(64,'Nicalis'),(3,'Nintendo'),(67,'NIS America'),(40,'Paradox Interactive'),(59,'Piranha Bytes'),(68,'Playdigious'),(65,'PQube'),(74,'Private Division'),(69,'Raw Fury'),(53,'Riot Games'),(81,'Rockstar Games'),(82,'Rockstar North'),(44,'SEGA'),(57,'Sega Europe'),(61,'Sony Computer Entertainment'),(9,'Sony Interactive Entertainment'),(49,'Square Enix'),(10,'Supergiant Games'),(36,'Take-Two Interactive'),(71,'Team17'),(54,'Tencent Games'),(1,'TesteDistribuidora'),(35,'THQ Nordic'),(75,'Tripwire Interactive'),(50,'Ubisoft'),(62,'Valve'),(34,'Valve Corporation'),(76,'Warhorse Studios'),(48,'Warner Bros. Interactive Entertainment'),(6,'Xbox Game Studios'),(70,'Yooreka Studio');

INSERT INTO genero VALUES (1,'Ação'),(35,'ActionRpg'),(3,'Aventura'),(9,'Battle Royale'),(26,'Card Game'),(33,'Educacional'),(8,'Esporte'),(19,'Exploração '),(4,'FPS'),(13,'Hack and Slash'),(18,'Horror escape'),(25,'Idle'),(17,'Indie'),(34,'Infantil'),(6,'Luta'),(11,'MMORPG'),(12,'Mundo Aberto'),(31,'Pixel Art'),(10,'Plataforma'),(22,'Point And Click'),(28,'Puzzle'),(32,'Retro'),(16,'Roguelike'),(15,'Roguelite'),(5,'RPG'),(14,'SandBox'),(7,'Simulacao'),(2,'Sobrevivencia'),(21,'Souls Like '),(29,'Stealth'),(20,'Survival Horror'),(36,'Tabuleiro'),(24,'Tower Defense'),(27,'TPS'),(30,'Tycoon');

INSERT INTO lista VALUES (1,'Geral'),(2,'Jogando'),(3,'Completo'),(4,'Abandonado'),(5,'Pausado'),(6,'Desejo'),(7,'Favoritos');

INSERT INTO modo VALUES (2,'Cooperativo'),(5,'Cooperativo Local'),(11,'MMO'),(3,'Multijogador'),(6,'Multijogador Local'),(12,'Offline'),(4,'Online'),(7,'RogueLike'),(1,'Um Jogador');

INSERT INTO permissao VALUES (2,'Administrador'),(1,'Usuario');

INSERT INTO plataforma VALUES (16,'Google Stadia'),(12,'Nintendo Switch'),(1,'PC'),(19,'PlayStation'),(18,'PlayStation 2'),(17,'PlayStation 3'),(14,'PlayStation 4'),(20,'PlayStation 5'),(13,'Wii U'),(21,'Xbox 360'),(15,'Xbox One');

INSERT INTO usuario VALUES (1,2,'AokiFernandes','Aoki','duduzebas@gmail.com','AokiFer',NULL,NULL),(2,2,'ThiagoDosSantos','Sr_Xurineio','ThiagoDosSantos','SantosThiago',NULL,NULL),(5,1,'Guilherme Laurindo','Abobora12','LaurindoG@gmail.com','Guilherme12',NULL,NULL),(20,1,'GuitesteAguero','Aguero','teste@fml.com','123abc123',NULL,NULL);

INSERT INTO jogo VALUES (2,2,2,'The Isle','The Isle é um jogo de sobrevivência em mundo aberto e horror.','2015-11-01','https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/376210/capsule_616x353.jpg?t=1653237914',6.0),(3,3,3,'The Legend of Zelda: Breath of the Wild','Em um reino devastado, Link deve explorar Hyrule para derrotar Calamity Ganon.','2017-03-03','https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_656/b_white/f_auto/q_auto/ncom/software/switch/70010000000025/7137262b5a64d921e193653f8aa0b722925abc5680380ca0e18a5cfd91697f58',NULL),(4,4,4,'Elden Ring','Um RPG de ação em um mundo aberto criado por Hidetaka Miyazaki e George R.R. Martin.','2022-02-25','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5Nou4oHurJxom1LW1QZvXbvtsRRzpNTD28g&s',NULL),(5,5,5,'Fortnite','Um jogo de battle royale onde 100 jogadores lutam até restar um vencedor.','2017-07-25','https://cms-assets.unrealengine.com/cm6l5gfpm05kr07my04cqgy2x/cm9wwjg2r2n9e08n4hrfeouns',NULL),(6,6,6,'Minecraft','Construa, explore e sobreviva em um mundo gerado proceduralmente.','2011-11-18','https://image.api.playstation.com/vulcan/img/cfn/11307uYG0CXzRuA9aryByTHYrQLFz-HVQ3VVl7aAysxK15HMpqjkAIcC_R5vdfZt52hAXQNHoYhSuoSq_46_MT_tDBcLu49I.png',NULL),(7,7,7,'Cyberpunk 2077','Em Night City, um mercenário busca um implante único que concede a imortalidade.','2020-12-10','https://www.cyberpunk.net/build/images/social-thumbnail-en-ddcf4d23.jpg',NULL),(8,8,8,'FIFA 23','O FIFA 23 é o último jogo da franquia FIFA desenvolvido pela Electronic Arts, antes da mudança para a EA Sports FC.','2022-09-30','https://assets.nintendo.com/image/upload/q_auto/f_auto/ncom/software/switch/70010000047794/40f9e2f6d344d2607d4be72c6c4ebd3c18717ff87a56d6bbc303c42e58dd570d',NULL),(9,9,9,'God of War: Ragnarök','God of War Ragnarök dá continuidade à história de Kratos e Atreus, ambientada após os eventos do jogo anterior.','2022-11-09','https://image.api.playstation.com/vulcan/ap/rnd/202207/1210/4xJ8XB3bi888QTLZYdl7Oi0s.png',NULL),(10,10,10,'Hades','Um roguelike onde Zagreus tenta escapar do Submundo grego.','2020-09-17','https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiDmuxS38ekrs51ij4WHn9A1mYq1lfonwn52hLcCDtq3O5qqjLkUPd5dBa7g3Gxc-rnhaAmLcHMl1LaVbCgt4TaHPr36C1JdCYKX49oEHLBzIjcwX3SK37hZAX1pSlPoFVct28Yj9JKepY/w1200-h630-p-k-no-nu/H2x1_NSwitchDS_Hades.png',NULL),(11,11,11,'Among Us','Um jogo de dedução social onde tripulantes precisam encontrar o impostor.','2018-06-15','https://upload.wikimedia.org/wikipedia/pt/7/72/AmongUs_CoverArt.jpg',NULL),(12,8,12,'Apex Legends','Um battle royale futurista com personagens únicos e habilidades especiais.','2019-02-04','https://image.api.playstation.com/vulcan/ap/rnd/202206/0720/eEczyEMDd2B8PfNAh4hBgl67.png',NULL),(25,81,13,'Red Dead Redemption 2','Em 1899, o fora da lei Arthur Morgan enfrenta o declínio do Velho Oeste e perseguições governamentais.','0018-10-26','https://cdn.dlcompare.com/game_tetiere/upload/gameimage/file/25273.jpeg.webp',NULL),(26,81,428,'Grand Theft Auto V','Três criminosos realizam assaltos em San Andreas sob pressão governamental, explorando um vasto mundo aberto.','2013-02-17','https://assetsio.gnwcdn.com/eurogamer-zjp1vx.jpg?width=1600&height=900&fit=crop&quality=100&format=png&enable=upscale&auto=webp',NULL);

INSERT INTO avaliacao VALUES (16,2,1,'Jogo muito bom um amigo me recomenda toda hora!',6.0,'2025-07-17','2025-07-17');

INSERT INTO genero_do_jogo VALUES (2,2),(2,3),(2,19),(3,1),(3,3),(4,5),(4,12),(5,4),(5,9),(6,2),(6,14),(7,1),(7,12),(8,7),(8,8),(9,1),(9,5),(9,13),(10,1),(10,5),(11,1),(11,9),(12,4),(12,9),(25,1),(25,3),(26,1),(26,3);

INSERT INTO modo_de_jogo VALUES (2,2),(2,3),(2,4),(2,5),(3,1),(8,4),(9,1),(25,1),(25,3),(26,1),(26,3);

INSERT INTO plataforma_de_jogo VALUES (1,2),(1,8),(1,9),(1,25),(1,26),(12,3),(14,26),(16,25),(21,26);

INSERT INTO jogo_adicionado VALUES (1,1,5),(1,1,8),(1,1,10),(1,1,2),(2,1,2),(4,1,5),(5,1,6),(7,1,6),(3,1,10),(7,1,10);

-- ---------------------------------------------------------------------------
-- Foreign keys
-- ---------------------------------------------------------------------------

ALTER TABLE usuario
  ADD CONSTRAINT fk_usuario_permissao FOREIGN KEY (id_permissao) REFERENCES permissao (id_permissao);

ALTER TABLE jogo
  ADD CONSTRAINT fk_jogo_desenvolvedora FOREIGN KEY (id_desenvolvedora) REFERENCES desenvolvedora (id_desenvolvedora),
  ADD CONSTRAINT fk_jogo_distribuidora FOREIGN KEY (id_distribuidora) REFERENCES distribuidora (id_distribuidora);

ALTER TABLE avaliacao
  ADD CONSTRAINT fk_avaliacao_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  ADD CONSTRAINT fk_avaliacao_jogo FOREIGN KEY (id_jogo) REFERENCES jogo (id_jogo);

ALTER TABLE genero_do_jogo
  ADD CONSTRAINT fk_genero_do_jogo_genero FOREIGN KEY (id_genero) REFERENCES genero (id_genero),
  ADD CONSTRAINT fk_genero_do_jogo_jogo FOREIGN KEY (id_jogo) REFERENCES jogo (id_jogo);

ALTER TABLE modo_de_jogo
  ADD CONSTRAINT fk_modo_de_jogo_modo FOREIGN KEY (id_modo) REFERENCES modo (id_modo),
  ADD CONSTRAINT fk_modo_de_jogo_jogo FOREIGN KEY (id_jogo) REFERENCES jogo (id_jogo);

ALTER TABLE plataforma_de_jogo
  ADD CONSTRAINT fk_plataforma_de_jogo_plataforma FOREIGN KEY (id_plataforma) REFERENCES plataforma (id_plataforma),
  ADD CONSTRAINT fk_plataforma_de_jogo_jogo FOREIGN KEY (id_jogo) REFERENCES jogo (id_jogo);

ALTER TABLE jogo_adicionado
  ADD CONSTRAINT fk_jogo_adicionado_lista FOREIGN KEY (id_lista) REFERENCES lista (id_lista),
  ADD CONSTRAINT fk_jogo_adicionado_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  ADD CONSTRAINT fk_jogo_adicionado_jogo FOREIGN KEY (id_jogo) REFERENCES jogo (id_jogo);

-- ---------------------------------------------------------------------------
-- Reset identity sequences to match the original AUTO_INCREMENT values
-- (next generated id continues after the highest seeded id)
-- ---------------------------------------------------------------------------

SELECT setval('desenvolvedora_id_desenvolvedora_seq', 429, false);
SELECT setval('distribuidora_id_distribuidora_seq', 83, false);
SELECT setval('genero_id_genero_seq', 37, false);
SELECT setval('lista_id_lista_seq', 8, false);
SELECT setval('modo_id_modo_seq', 13, false);
SELECT setval('permissao_id_permissao_seq', 3, false);
SELECT setval('plataforma_id_plataforma_seq', 22, false);
SELECT setval('usuario_id_usuario_seq', 22, false);
SELECT setval('jogo_id_jogo_seq', 27, false);
SELECT setval('avaliacao_id_avaliacao_seq', 17, false);
