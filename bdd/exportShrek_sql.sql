-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  ven. 01 fév. 2019 à 18:09
-- Version du serveur :  10.3.9-MariaDB
-- Version de PHP :  7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `zil3-zmazele00`
--

-- --------------------------------------------------------

--
-- Structure de la table `adm_admin_t`
--

CREATE TABLE `adm_admin_t` (
  `adm_admin_id` int(10) NOT NULL,
  `adm_email` varchar(100) NOT NULL,
  `adm_mdp` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adm_admin_t`
--

INSERT INTO `adm_admin_t` (`adm_admin_id`, `adm_email`, `adm_mdp`) VALUES
(1, 'shrek@mail.com', 'somebody');

-- --------------------------------------------------------

--
-- Structure de la table `cat_categorie_t`
--

CREATE TABLE `cat_categorie_t` (
  `cat_categorie_id` int(4) NOT NULL,
  `cat_intitule` varchar(250) NOT NULL,
  `cat_description` varchar(750) NOT NULL DEFAULT '',
  `sdr_sondeur_id` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cat_categorie_t`
--

INSERT INTO `cat_categorie_t` (`cat_categorie_id`, `cat_intitule`, `cat_description`, `sdr_sondeur_id`) VALUES
(1, 'Jeune actif', 'Personnes entre 18 et 25 ans qui étudient/travaillent', NULL),
(2, 'Retraité', 'Personnes à la retraite', NULL),
(3, 'Sportif', 'Personne qui font régulièrement du sport', NULL),
(4, 'Etudiant', 'Personnes qui sont actuellement en étude', NULL),
(5, 'Politique', 'Sondage liées à la politique', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `par_participant_t`
--

CREATE TABLE `par_participant_t` (
  `sdg_sondage_id` int(4) NOT NULL,
  `snd_sonde_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `que_quest_t`
--

CREATE TABLE `que_quest_t` (
  `que_quest_id` int(4) NOT NULL,
  `que_intitule` varchar(250) NOT NULL,
  `que_type` tinyint(1) NOT NULL DEFAULT 0,
  `que_ordre` int(4) NOT NULL,
  `sdg_sondage_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `rep_reponse_t`
--

CREATE TABLE `rep_reponse_t` (
  `rep_reponse_id` int(4) NOT NULL,
  `rep_intitule` varchar(250) NOT NULL,
  `que_quest_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `res_resultat_t`
--

CREATE TABLE `res_resultat_t` (
  `res_resultat_id` int(4) NOT NULL,
  `res_date_rep` date NOT NULL DEFAULT current_timestamp(),
  `rep_reponse_id` int(4) NOT NULL,
  `snd_sonde_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sdg_sondage_t`
--

CREATE TABLE `sdg_sondage_t` (
  `sdg_sondage_id` int(4) NOT NULL,
  `sdg_intitule` varchar(250) NOT NULL,
  `sdg_actif` tinyint(1) NOT NULL DEFAULT 0,
  `sdg_description` varchar(750) NOT NULL DEFAULT '',
  `sdg_dateDebut` date NOT NULL DEFAULT current_timestamp(),
  `sdg_dateFin` date NOT NULL,
  `sdr_sondeur_id` int(4) DEFAULT NULL,
  `cat_categorie_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sdr_sondeur_t`
--

CREATE TABLE `sdr_sondeur_t` (
  `sdr_sondeur_id` int(4) NOT NULL,
  `sdr_nom` varchar(100) NOT NULL,
  `sdr_prenom` varchar(100) NOT NULL,
  `sdr_mail` varchar(100) NOT NULL,
  `sdr_mdp` varchar(100) NOT NULL,
  `adm_admin_id` int(4) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sdr_sondeur_t`
--

INSERT INTO `sdr_sondeur_t` (`sdr_sondeur_id`, `sdr_nom`, `sdr_prenom`, `sdr_mail`, `sdr_mdp`, `adm_admin_id`) VALUES
(1, 'Lesne', 'Alexis', 'alexis.lesne@mail.com', 'lesneA', 1),
(2, 'Neau', 'Maelic', 'maelic.neau@mail.com', 'neauM', 1),
(3, 'Lepage', 'Vicent', 'vincent.lepage@mail.com', 'lepageV', 1),
(4, 'Fourre', 'Clarisse', 'clarisse.fourre@mail.com', 'fourreC', 1),
(5, 'Maze', 'Leo', 'leo.maze@mail.com', 'mazeL', 1);

-- --------------------------------------------------------

--
-- Structure de la table `snd_sonde_t`
--

CREATE TABLE `snd_sonde_t` (
  `snd_sonde_id` int(4) NOT NULL,
  `snd_nom` varchar(100) NOT NULL,
  `snd_prenom` varchar(100) NOT NULL,
  `snd_pseudo` varchar(100) NOT NULL,
  `snd_age` int(4) NOT NULL DEFAULT 18,
  `snd_password` varchar(100) NOT NULL,
  `snd_email` varchar(100) NOT NULL,
  `cat_categorie_id` int(4) DEFAULT NULL,
  `adm_admin_id` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adm_admin_t`
--
ALTER TABLE `adm_admin_t`
  ADD PRIMARY KEY (`adm_admin_id`);

--
-- Index pour la table `cat_categorie_t`
--
ALTER TABLE `cat_categorie_t`
  ADD PRIMARY KEY (`cat_categorie_id`),
  ADD KEY `FK_cat_sdr` (`sdr_sondeur_id`);

--
-- Index pour la table `par_participant_t`
--
ALTER TABLE `par_participant_t`
  ADD PRIMARY KEY (`sdg_sondage_id`,`snd_sonde_id`),
  ADD KEY `FK_par_snd` (`snd_sonde_id`);

--
-- Index pour la table `que_quest_t`
--
ALTER TABLE `que_quest_t`
  ADD PRIMARY KEY (`que_quest_id`),
  ADD KEY `FK_que_sdg` (`sdg_sondage_id`);

--
-- Index pour la table `rep_reponse_t`
--
ALTER TABLE `rep_reponse_t`
  ADD PRIMARY KEY (`rep_reponse_id`),
  ADD KEY `FK_rep_que` (`que_quest_id`);

--
-- Index pour la table `res_resultat_t`
--
ALTER TABLE `res_resultat_t`
  ADD PRIMARY KEY (`res_resultat_id`),
  ADD KEY `FK_res_rep` (`rep_reponse_id`),
  ADD KEY `FK_res_snd` (`snd_sonde_id`);

--
-- Index pour la table `sdg_sondage_t`
--
ALTER TABLE `sdg_sondage_t`
  ADD PRIMARY KEY (`sdg_sondage_id`),
  ADD KEY `FK_sdg_sdr` (`sdr_sondeur_id`),
  ADD KEY `FK_sdg_cat` (`cat_categorie_id`);

--
-- Index pour la table `sdr_sondeur_t`
--
ALTER TABLE `sdr_sondeur_t`
  ADD PRIMARY KEY (`sdr_sondeur_id`),
  ADD KEY `FK_sdr_adm` (`adm_admin_id`);

--
-- Index pour la table `snd_sonde_t`
--
ALTER TABLE `snd_sonde_t`
  ADD PRIMARY KEY (`snd_sonde_id`),
  ADD KEY `FK_snd_cat` (`cat_categorie_id`),
  ADD KEY `FK_snd_adm` (`adm_admin_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adm_admin_t`
--
ALTER TABLE `adm_admin_t`
  MODIFY `adm_admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `cat_categorie_t`
--
ALTER TABLE `cat_categorie_t`
  MODIFY `cat_categorie_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `que_quest_t`
--
ALTER TABLE `que_quest_t`
  MODIFY `que_quest_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `rep_reponse_t`
--
ALTER TABLE `rep_reponse_t`
  MODIFY `rep_reponse_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `res_resultat_t`
--
ALTER TABLE `res_resultat_t`
  MODIFY `res_resultat_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `sdg_sondage_t`
--
ALTER TABLE `sdg_sondage_t`
  MODIFY `sdg_sondage_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `sdr_sondeur_t`
--
ALTER TABLE `sdr_sondeur_t`
  MODIFY `sdr_sondeur_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `snd_sonde_t`
--
ALTER TABLE `snd_sonde_t`
  MODIFY `snd_sonde_id` int(4) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cat_categorie_t`
--
ALTER TABLE `cat_categorie_t`
  ADD CONSTRAINT `FK_cat_sdr` FOREIGN KEY (`sdr_sondeur_id`) REFERENCES `sdr_sondeur_t` (`sdr_sondeur_id`);

--
-- Contraintes pour la table `par_participant_t`
--
ALTER TABLE `par_participant_t`
  ADD CONSTRAINT `FK_par_sdg` FOREIGN KEY (`sdg_sondage_id`) REFERENCES `sdg_sondage_t` (`sdg_sondage_id`),
  ADD CONSTRAINT `FK_par_snd` FOREIGN KEY (`snd_sonde_id`) REFERENCES `snd_sonde_t` (`snd_sonde_id`);

--
-- Contraintes pour la table `que_quest_t`
--
ALTER TABLE `que_quest_t`
  ADD CONSTRAINT `FK_que_sdg` FOREIGN KEY (`sdg_sondage_id`) REFERENCES `sdg_sondage_t` (`sdg_sondage_id`);

--
-- Contraintes pour la table `rep_reponse_t`
--
ALTER TABLE `rep_reponse_t`
  ADD CONSTRAINT `FK_rep_que` FOREIGN KEY (`que_quest_id`) REFERENCES `que_quest_t` (`que_quest_id`);

--
-- Contraintes pour la table `res_resultat_t`
--
ALTER TABLE `res_resultat_t`
  ADD CONSTRAINT `FK_res_rep` FOREIGN KEY (`rep_reponse_id`) REFERENCES `rep_reponse_t` (`rep_reponse_id`),
  ADD CONSTRAINT `FK_res_snd` FOREIGN KEY (`snd_sonde_id`) REFERENCES `snd_sonde_t` (`snd_sonde_id`);

--
-- Contraintes pour la table `sdg_sondage_t`
--
ALTER TABLE `sdg_sondage_t`
  ADD CONSTRAINT `FK_sdg_cat` FOREIGN KEY (`cat_categorie_id`) REFERENCES `cat_categorie_t` (`cat_categorie_id`),
  ADD CONSTRAINT `FK_sdg_sdr` FOREIGN KEY (`sdr_sondeur_id`) REFERENCES `sdr_sondeur_t` (`sdr_sondeur_id`);

--
-- Contraintes pour la table `sdr_sondeur_t`
--
ALTER TABLE `sdr_sondeur_t`
  ADD CONSTRAINT `FK_sdr_adm` FOREIGN KEY (`adm_admin_id`) REFERENCES `adm_admin_t` (`adm_admin_id`);

--
-- Contraintes pour la table `snd_sonde_t`
--
ALTER TABLE `snd_sonde_t`
  ADD CONSTRAINT `FK_snd_adm` FOREIGN KEY (`adm_admin_id`) REFERENCES `adm_admin_t` (`adm_admin_id`),
  ADD CONSTRAINT `FK_snd_cat` FOREIGN KEY (`cat_categorie_id`) REFERENCES `cat_categorie_t` (`cat_categorie_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
