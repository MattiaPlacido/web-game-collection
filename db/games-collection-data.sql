CREATE DATABASE  IF NOT EXISTS `games_collection` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `games_collection`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: games_collection
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `game_genre`
--

LOCK TABLES `game_genre` WRITE;
/*!40000 ALTER TABLE `game_genre` DISABLE KEYS */;
INSERT INTO `game_genre` VALUES (13,9),(15,9),(18,9),(19,9),(22,9),(25,9),(29,9),(30,9),(36,9),(38,9),(39,9),(13,10),(16,10),(17,10),(18,10),(19,10),(21,10),(23,10),(26,10),(28,10),(31,10),(32,10),(33,10),(34,10),(36,10),(37,10),(41,10),(13,11),(15,11),(19,11),(20,11),(24,11),(28,11),(30,11),(40,11),(18,12),(19,12),(20,12),(37,12),(22,13),(25,13),(29,13),(32,13),(38,13),(39,13),(40,13),(16,14),(17,14),(21,14),(24,14),(26,14),(27,14),(31,14),(34,14),(35,14),(41,14),(42,14),(23,15),(27,15),(33,15),(35,15),(42,15),(18,20);
/*!40000 ALTER TABLE `game_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `game_platform`
--

LOCK TABLES `game_platform` WRITE;
/*!40000 ALTER TABLE `game_platform` DISABLE KEYS */;
INSERT INTO `game_platform` VALUES (13,5),(15,5),(18,5),(19,5),(20,5),(21,5),(22,5),(24,5),(25,5),(26,5),(28,5),(29,5),(30,5),(32,5),(35,5),(36,5),(37,5),(38,5),(39,5),(40,5),(13,6),(15,6),(16,6),(17,6),(18,6),(19,6),(20,6),(21,6),(22,6),(24,6),(28,6),(29,6),(30,6),(31,6),(32,6),(34,6),(35,6),(36,6),(37,6),(38,6),(39,6),(40,6),(41,6),(42,6),(16,7),(17,7),(23,7),(25,7),(26,7),(27,7),(31,7),(33,7),(34,7),(41,7),(42,7),(18,8),(23,8),(27,8),(33,8),(18,10),(18,11);
/*!40000 ALTER TABLE `game_platform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (13,'2015-05-19','https://assets.bwbx.io/images/users/iqjWHBFdfxIU/itgEDbboh.mg/v1/-1x-1.webp','The Witcher 3: Wild Hunt','CD Projekt Red','An open-world RPG set in a dark fantasy universe, where players control Geralt of Rivia.'),(15,'2020-12-10','https://imageio.forbes.com/specials-images/imageserve/5fccec7d887f1e26348cc6b3/Cyberpunk-2077/960x0.jpg?format=jpg&width=1440','Cyberpunk 2077','CD Projekt Red','A futuristic open-world RPG set in Night City, where players play as V, a mercenary with various cybernetic enhancements.'),(16,'2017-03-03','https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/The_Legend_of_Zelda_Breath_of_the_Wild.svg/1920px-The_Legend_of_Zelda_Breath_of_the_Wild.svg.png','The Legend of Zelda: Breath of the Wild','Nintendo','An open-world action-adventure game set in Hyrule, featuring puzzle-solving and combat.'),(17,'2017-10-27','https://hd2.tudocdn.net/721121?w=980&h=431','Super Mario Odyssey','Nintendo','A 3D platformer where Mario embarks on an adventure across various kingdoms to rescue Princess Peach.'),(18,'2013-09-17','https://upload.wikimedia.org/wikipedia/en/a/a5/Grand_Theft_Auto_V.png','Grand Theft Auto V','Rockstar Games','An action-adventure game set in the fictional city of Los Santos, where players engage in heists and crime.'),(19,'2011-11-18','https://assets.nintendo.eu/image/upload/f_auto,c_limit,w_1920,q_auto:low/MNS/NOE/70010000000963/SQ_NSwitch_Minecraft','Minecraft','Mojang','A sandbox game that allows players to build and explore procedurally generated worlds made of blocks.'),(20,'2017-07-25','https://www.giantbomb.com/a/uploads/scale_small/8/87790/2952214-box_fn.png','Fortnite','Epic Games','A battle royale game where players fight to be the last one standing in a shrinking play zone.'),(21,'2011-11-11','https://www.nintendo.com/eu/media/images/06_screenshots/games_5/nintendo_switch_6/nswitch_theelderscrollsvskyrim/NSwitch_TheElderScrollsVSkyrim_08_image950w.jpg','The Elder Scrolls V: Skyrim','Bethesda Softworks','An open-world RPG set in the fantasy world of Tamriel, where players take on the role of the Dragonborn.'),(22,'2018-04-20','https://cdn1.epicgames.com/offer/3ddd6a590da64e3686042d108968a6b2/EGS_GodofWar_SantaMonicaStudio_S2_1200x1600-fbdf3cbc2980749091d52751ffabb7b7_1200x1600-fbdf3cbc2980749091d52751ffabb7b7','God of War','Sony Interactive Entertainment','An action-adventure game set in the world of Norse mythology, following Kratos and his son Atreus.'),(23,'2016-05-24','https://example.com/overwatch.jpg','Overwatch','Blizzard Entertainment','A team-based first-person shooter with heroes, each having unique abilities, set in a near-future world.'),(24,'2019-02-04','https://example.com/apex_legends.jpg','Apex Legends','Respawn Entertainment','A battle royale game that features unique characters with different abilities in a futuristic setting.'),(25,'2017-02-28','https://example.com/horizon_zero_dawn.jpg','Horizon Zero Dawn','Guerrilla Games','An action RPG where players control Aloy in a world overrun by robotic creatures.'),(26,'2020-11-10','https://example.com/ac_valhalla.jpg','Assassin\'s Creed Valhalla','Ubisoft','An action RPG set in the Viking Age, where players control Eivor as they build their settlement and explore England.'),(27,'2020-06-19','https://example.com/tlou2.jpg','The Last of Us Part II','Naughty Dog','An emotional action-adventure game following Ellie and Joel in a post-apocalyptic world.'),(28,'2015-03-24','https://example.com/bloodborne.jpg','Bloodborne','Sony Computer Entertainment','An action RPG set in a gothic, nightmare world where players fight horrifying creatures.'),(29,'2019-03-22','https://example.com/sekiro.jpg','Sekiro: Shadows Die Twice','Activision','An action-adventure game where players control a shinobi in feudal Japan, combating samurai and mythical creatures.'),(30,'2020-04-10','https://example.com/ff7remake.jpg','Final Fantasy VII Remake','Square Enix','A remake of the classic RPG that follows Cloud Strife and his companions as they battle against the Shinra Corporation.'),(31,'2016-04-12','https://example.com/dark_souls_iii.jpg','Dark Souls III','Bandai Namco Entertainment','An action RPG set in a dark fantasy world, where players explore dangerous environments and fight brutal bosses.'),(32,'2014-11-18','https://example.com/dragon_age.jpg','Dragon Age: Inquisition','Electronic Arts','A fantasy RPG where players control the Inquisitor and lead an army to combat an impending dark force.'),(33,'2018-01-26','https://example.com/monsterhunterworld.jpg','Monster Hunter: World','Capcom','A hunting action game where players hunt large monsters in vast, open environments.'),(34,'2019-03-15','https://example.com/division2.jpg','The Division 2','Ubisoft','A tactical online RPG set in a dystopian future, where players fight to restore order to a broken Washington, D.C.'),(35,'2020-03-10','https://example.com/cod_warzone.jpg','Call of Duty: Warzone','Activision','A battle royale first-person shooter game, featuring large-scale combat and various player strategies.'),(36,'2009-10-27','https://example.com/leagueoflegends.jpg','League of Legends','Riot Games','A multiplayer online battle arena (MOBA) where players control champions to fight in teams.'),(37,'2020-06-02','https://example.com/valorant.jpg','Valorant','Riot Games','A tactical first-person shooter where players control agents, each with unique abilities, to plant or defuse bombs.'),(38,'2016-02-26','https://example.com/stardewvalley.jpg','Stardew Valley','ConcernedApe','A farming simulation game where players grow crops, raise animals, and interact with townsfolk in a small rural community.'),(39,'2016-06-14','https://example.com/deadbydaylight.jpg','Dead by Daylight','Behaviour Interactive','A multiplayer survival horror game where one player is a killer and others must escape from a deadly environment.'),(40,'2015-07-07','https://example.com/rocketleague.jpg','Rocket League','Psyonix','A vehicular soccer game where players control cars to score goals against each other.'),(41,'2020-08-04','https://example.com/fallguys.jpg','Fall Guys','Mediatonic','A chaotic battle royale game where players control jellybean-like characters in a series of obstacle courses.'),(42,'2019-02-13','https://example.com/tetris99.jpg','Tetris 99','Nintendo','A competitive puzzle game where 99 players compete against each other to be the last one standing.');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (6,'Roguelike','Roguelike (or rogue-like) is a style of role-playing game traditionally characterized by a dungeon crawl through procedurally generated levels, turn-based gameplay, grid-based movement, and permanent death of the player character.','ANY'),(9,'Action','Action games involve a lot of physical challenges, including hand-eye coordination and reaction-time.','ANY'),(10,'Adventure','Adventure games involve story-driven gameplay with puzzle-solving and exploration.','ANY'),(11,'Role-playing','Role-playing games (RPGs) allow players to assume the roles of characters in a fictional setting.','ANY'),(12,'Simulation','Simulation games attempt to simulate real-world activities, such as driving, flying, or life simulation.','ANY'),(13,'Sports','Sports games simulate the practice of sports and games that involve physical challenges.','ANY'),(14,'Racing','Racing games challenge players to race vehicles on various tracks or courses.','ANY'),(15,'Strategy','Strategy games involve tactical decision-making and long-term planning to achieve a goal.','ADULT'),(16,'Fighting','Fighting games involve combat between characters, where players must use various techniques and abilities.','TEEN'),(17,'Horror','Horror games focus on inducing fear through suspense, atmosphere, and often combat with terrifying creatures.','ADULT'),(18,'Puzzle','Puzzle games challenge the player with logic-based problems or manipulation of the environment.','ANY'),(19,'Platformer','Platformer games involve navigating a character through levels using jumping and climbing mechanics.','FAMILY'),(20,'Shooter','Shooter games involve a player aiming and shooting at targets, often with firearms or other weapons.','TEEN');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `platforms`
--

LOCK TABLES `platforms` WRITE;
/*!40000 ALTER TABLE `platforms` DISABLE KEYS */;
INSERT INTO `platforms` VALUES (5,'PlayStation 5','Sony','The PlayStation 5 is a powerful home video game console with advanced graphics, fast load times, and support for next-gen gaming experiences.'),(6,'Xbox Series X','Microsoft','The Xbox Series X is a next-gen gaming console offering fast performance, high-quality graphics, and access to a massive gaming library.'),(7,'Nintendo Switch','Nintendo','A hybrid gaming console from Nintendo, allowing for both handheld and docked play. Known for its unique games and flexibility.'),(8,'PC (Windows)','Various','A platform that runs on personal computers, supporting a wide variety of games and hardware configurations.'),(9,'Nintendo 3DS','Nintendo','A portable handheld gaming system that features 3D visuals without the need for special glasses.'),(10,'Xbox Series S','Microsoft','The Xbox Series S is a more affordable version of the Series X, providing next-gen performance at a lower price point.'),(11,'PlayStation 4','Sony','The PlayStation 4 is a home gaming console offering an extensive library of games and immersive gameplay experiences.'),(12,'PlayStation Vita','Sony','A handheld gaming console from Sony with a focus on high-quality portable gaming.');
/*!40000 ALTER TABLE `platforms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_user`
--

LOCK TABLES `role_user` WRITE;
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
INSERT INTO `role_user` VALUES (1,1),(2,2),(3,2);
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'{noop}password','Utente1'),(2,'{noop}password','Utente2'),(3,'{noop}prova','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-04 13:10:52
