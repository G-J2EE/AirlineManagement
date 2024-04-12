-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 12 avr. 2024 à 21:39
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `airlinedb`
--

-- --------------------------------------------------------

--
-- Structure de la table `bookingtbl`
--

CREATE TABLE `bookingtbl` (
  `TicketId` int(11) NOT NULL,
  `PName` varchar(20) NOT NULL,
  `FlCode` varchar(20) NOT NULL,
  `PGen` varchar(10) NOT NULL,
  `PPass` varchar(20) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Nationality` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `bookingtbl`
--

INSERT INTO `bookingtbl` (`TicketId`, `PName`, `FlCode`, `PGen`, `PPass`, `Amount`, `Nationality`) VALUES
(2, 'Khaoula', 'GT346', 'Femme', 'J2932023', 237, 'Marrocaine'),
(3, 'Khaoula', 'GT346', 'Femme', 'J2932023', 128, 'Marrocaine'),
(4, 'Khaoula', 'GT346', 'Femme', 'J2932023', 666, 'Marrocaine'),
(5, 'Khaoula', 'GT346', 'Femme', 'J2932023', 22, 'Marrocaine'),
(6, 'Khaoula', 'GT346', 'Femme', 'J2932023', 45, 'Marrocaine'),
(7, 'Khaoula', 'GT346', 'Femme', 'J2932023', 3345, 'Marrocaine'),
(8, 'Khaoula', 'GT346', 'Femme', 'J2932023', 237, 'Marrocaine'),
(9, 'Nada', 'GT346', 'Femme', 'FR4568', 2379, 'France'),
(10, 'Nada', 'GT346', 'Femme', 'FR4568', 555, 'France'),
(11, 'Nada', 'GT346', 'Femme', 'FR4568', 6680, 'France'),
(12, 'Khaoula', 'GT346', 'Femme', 'J2932023', 4596, 'Marrocaine'),
(13, 'Khaoula', 'GT346', 'Femme', 'J2932023', 9900, 'Marrocaine'),
(14, 'Khaoula', 'GT346', 'Femme', 'J2932023', 4477, 'Marrocaine');

-- --------------------------------------------------------

--
-- Structure de la table `cancellationtbl`
--

CREATE TABLE `cancellationtbl` (
  `Cancid` int(11) NOT NULL,
  `Tickid` int(11) NOT NULL,
  `FlCode` varchar(20) NOT NULL,
  `CancDate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cancellationtbl`
--

INSERT INTO `cancellationtbl` (`Cancid`, `Tickid`, `FlCode`, `CancDate`) VALUES
(1, 1, 'GT346', 'Wed Apr 03 00:00:00 WET 2024'),
(2, 5, 'GT346', 'Thu Apr 04 00:00:00 WET 2024'),
(3, 1, 'GT346', 'Mon Apr 01 02:07:29 WET 2024'),
(4, 15, '1234', 'Sat Apr 06 19:18:15 WET 2024');

-- --------------------------------------------------------

--
-- Structure de la table `flights`
--

CREATE TABLE `flights` (
  `flightcode` varchar(50) DEFAULT NULL,
  `source_l` varchar(50) DEFAULT NULL,
  `destination_l` varchar(50) DEFAULT NULL,
  `takeoffd` date DEFAULT NULL,
  `nbseats` int(11) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `flights`
--

INSERT INTO `flights` (`flightcode`, `source_l`, `destination_l`, `takeoffd`, `nbseats`, `amount`) VALUES
('123456', 'UAE', 'USA', '2024-10-23', 33, '3333.00'),
('1234', 'ARGENTINA', 'USA', '2024-04-19', 123, '4444.00'),
('56764576', 'JAPAN', 'USA', '2024-04-06', 45, '6625.00');

-- --------------------------------------------------------

--
-- Structure de la table `passengerstbl`
--

CREATE TABLE `passengerstbl` (
  `PI` int(11) NOT NULL,
  `PName` varchar(20) NOT NULL,
  `PNat` varchar(20) NOT NULL,
  `PGen` varchar(10) NOT NULL,
  `PPass` varchar(20) NOT NULL,
  `PAdd` varchar(50) NOT NULL,
  `Pphone` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `passengerstbl`
--

INSERT INTO `passengerstbl` (`PI`, `PName`, `PNat`, `PGen`, `PPass`, `PAdd`, `Pphone`) VALUES
(1, 'Khaoula', 'Marrocaine', 'Femme', 'J2932023', 'iufiejfjefjzoepz', 678265566),
(2, 'Nada', 'France', 'Femme', 'FR4568', 'jhioiuipoi', 8754356);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`user_id`, `full_name`, `email`, `password`) VALUES
(1, 'Admin', 'admin@gmail.com', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `bookingtbl`
--
ALTER TABLE `bookingtbl`
  ADD PRIMARY KEY (`TicketId`);

--
-- Index pour la table `cancellationtbl`
--
ALTER TABLE `cancellationtbl`
  ADD PRIMARY KEY (`Cancid`);

--
-- Index pour la table `passengerstbl`
--
ALTER TABLE `passengerstbl`
  ADD PRIMARY KEY (`PI`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
