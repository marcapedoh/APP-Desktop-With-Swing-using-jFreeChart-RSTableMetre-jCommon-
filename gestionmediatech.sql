-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 20 mars 2023 à 20:58
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionmediatech`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom_client` varchar(30) NOT NULL,
  `Prenom_client` varchar(40) NOT NULL,
  `adresse_client` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `Prenom_client`, `adresse_client`) VALUES
(7, 'iuytfdx', 'errtyjukliom', 'rtyjklfghjkl'),
(8, 'ertyu', 'fghjkl:;,nbv', 'bn,;kjhgf'),
(9, 'Blakime', 'hugues essodom malik', 'agoe-télessou'),
(11, 'Apedoh', 'marc kékéli', 'lomé togo'),
(12, 'Tchani', 'rajaa', 'vakpossito'),
(13, 'ADZAHO', 'stacy', 'télésou'),
(14, 'qsdfghj', 'rtkjhgf', 'dfgho');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `Id_commande` int(11) NOT NULL,
  `ref_commande` varchar(45) NOT NULL,
  `Qte_prod` int(11) NOT NULL,
  `montant` int(11) NOT NULL,
  `Date_commande` varchar(100) NOT NULL,
  `Date_recuCommande` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`Id_commande`, `ref_commande`, `Qte_prod`, `montant`, `Date_commande`, `Date_recuCommande`) VALUES
(1, 'dfghj', 17, 549894, 'Mon Jan 04 00:00:00 CET 2021', NULL),
(2, 'dfghj', 17, 549894, 'Mon Jan 04 00:00:00 CET 2021', NULL),
(3, 'azsdcvbnjk', 7665, 415515, 'Mon Jan 03 00:00:00 CET 2022', NULL),
(4, 'qsfg', 789, 589, 'Mon Dec 31 00:00:00 CET 2018', NULL),
(5, 'dghj', 5, 684, 'Mon Jan 03 00:00:00 CET 2005', NULL),
(6, 'dfghj', 0, 4852, '14/02/2021', NULL),
(8, 'serveur dell', 45, 7890000, '20/03/2023', '25/03/2023'),
(9, 'ipad330', 259, 895000, '20/03/2022', '23/03/2023');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `id_facture` int(11) NOT NULL,
  `ref_facture` varchar(30) NOT NULL,
  `produits` varchar(30) NOT NULL,
  `Montant` int(11) NOT NULL,
  `nomFournisseur` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id_facture`, `ref_facture`, `produits`, `Montant`, `nomFournisseur`) VALUES
(1, 'qsdfgh', 'yfgdfsds', 0, 'rdgf');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_prod` int(11) NOT NULL,
  `nom_prod` varchar(25) NOT NULL,
  `qte_paye` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_prod`, `nom_prod`, `qte_paye`) VALUES
(4, 'Souris sans fil', 100),
(5, 'pare feu fortigate', 75),
(6, 'Switch', 250),
(7, 'Samsung s20', 200),
(8, 'IPad', 800),
(9, 'Eau en poudre', 10),
(10, 'Eau en poudre', 10),
(11, 'Eau en poudre', 10),
(12, 'dfghjkhg', 15);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`Id_commande`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`id_facture`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_prod`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `Id_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `id_facture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_prod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
