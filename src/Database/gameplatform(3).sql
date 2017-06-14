-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--@Luka
-- Host: 127.0.0.1
-- Creato il: Mag 09, 2017 alle 11:29
-- Versione del server: 10.1.21-MariaDB
-- Versione PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gameplatform`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `game`
--

CREATE TABLE `game` (
  `id_gioco` int(10) NOT NULL,
  `titolo` varchar(50) NOT NULL,
  `genere` varchar(50) NOT NULL,
  `mediaVoto` float NOT NULL,
  `descrizione` text NOT NULL,
  `valore` int(10) NOT NULL,
  `path` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `gruppo`
--

CREATE TABLE `gruppo` (
  `id_gruppo` int(10) NOT NULL,
  `nomeGruppo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `gruppo/servizio`
--

CREATE TABLE `gruppo_servizio` (
  `id_servizio` int(10) NOT NULL,
  `id_gruppo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `image`
--

CREATE TABLE `image` (
  `id_image` int(10) NOT NULL,
  `path` varchar(500) NOT NULL,
  `titolo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `image/gioco`
--

CREATE TABLE `image_gioco` (
  `id_image` int(10) NOT NULL,
  `id_gioco` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `livello`
--

CREATE TABLE `livello` (
  `id_livello` int(10) NOT NULL,
  `numeroLivello` int(10) NOT NULL,
  `punteggioProssimoLivello` bigint(50) NOT NULL,
  `id_gioco` int(10) NOT NULL,
  `id_trofeo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `partita`
--

CREATE TABLE `partita` (
  `id_partita` int(10) NOT NULL,
  `punteggio` bigint(50) NOT NULL,
  `data` date NOT NULL,
  `id_gioco` int(10) NOT NULL,
  `id_user` int(10) NOT NULL,
  `id_livello` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `recensione`
--

CREATE TABLE `recensione` (
  `id_recensione` int(10) NOT NULL,
  `title` varchar(50) NOT NULL,
  `text` text NOT NULL,
  `approvata` tinyint(1) NOT NULL,
  `id_utente` int(10) NOT NULL,
  `id_gioco` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `servizio`
--

CREATE TABLE `servizio` (
  `id_servizio` int(10) NOT NULL,
  `pagine` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `trofei`
--

CREATE TABLE `trofei` (
  `id_trofeo` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `id_image` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `città` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `user/gruppo`
--

CREATE TABLE `user_gruppo` (
  `id_user` int(10) NOT NULL,
  `id_gruppo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `user/trofeo`
--

CREATE TABLE `user_trofeo` (
  `id_user` int(10) NOT NULL,
  `id_trofeo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id_gioco`);

--
-- Indici per le tabelle `gruppo`
--
ALTER TABLE `gruppo`
  ADD PRIMARY KEY (`id_gruppo`);

--
-- Indici per le tabelle `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id_image`);

--
-- Indici per le tabelle `livello`
--
ALTER TABLE `livello`
  ADD PRIMARY KEY (`id_livello`);

--
-- Indici per le tabelle `partita`
--
ALTER TABLE `partita`
  ADD PRIMARY KEY (`id_partita`);

--
-- Indici per le tabelle `recensione`
--
ALTER TABLE `recensione`
  ADD PRIMARY KEY (`id_recensione`);

--
-- Indici per le tabelle `trofei`
--
ALTER TABLE `trofei`
  ADD PRIMARY KEY (`id_trofeo`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
