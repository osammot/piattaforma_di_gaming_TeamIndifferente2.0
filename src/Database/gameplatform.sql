-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 17, 2017 alle 18:40
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
-- Struttura della tabella `gioco`
--

CREATE TABLE `gioco` (
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
-- Struttura della tabella `grupposervizio`
--

CREATE TABLE `grupposervizio` (
  `id_servizio` int(10) NOT NULL,
  `id_gruppo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `immagine`
--

CREATE TABLE `immagine` (
  `id_immagine` int(11) NOT NULL,
  `path` varchar(500) NOT NULL,
  `titolo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Struttura della tabella `immaginegioco`
--

CREATE TABLE `immaginegioco` (
  `id_immagine` int(10) NOT NULL,
  `titolo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `livello`
--

CREATE TABLE `livello` (
  `id_livello` int(10) NOT NULL,
  `numeroLivello` int(10) NOT NULL,
  `punteggioProssimoLivello` bigint(50) NOT NULL,
  `titolo` varchar(50) NOT NULL,
  `id_trofeo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `partite`
--

CREATE TABLE `partite` (
  `id_partita` int(10) NOT NULL,
  `punteggio` bigint(50) NOT NULL,
  `data` date NOT NULL,
  `username` varchar(50) NOT NULL,
  `id_livello` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `recensione`
--

CREATE TABLE `recensione` (
  `id_recensione` int(10) NOT NULL,
  `titoloRecensione` varchar(50) NOT NULL,
  `testo` text NOT NULL,
  `approvata` tinyint(1) NOT NULL,
  `username` varchar(50) NOT NULL,
  `titoloGioco` varchar(50) NOT NULL
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
-- Struttura della tabella `trofeo`
--

CREATE TABLE `trofeo` (
  `id_trofeo` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `id_immagine` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `username` varchar(50) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `indirizzo` varchar(100) NOT NULL,
  `email` varchar(30) NOT NULL,
  `città` varchar(30) NOT NULL,
  `ruolo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`username`, `nome`, `cognome`, `password`, `indirizzo`, `email`, `città`, `ruolo`) VALUES
('eugenioa', 'eugenio', 'mancini', 'a123', 'via tre ponti', 'eugenio@live.it', 'avezzano', 'utenteSemplice'),
('lucaa', 'luca', 'dorazio', 'a123', 'via fiume', 'lucaadorazio@gmail.com', 'roccavivi', 'amministratore'),
('stefanoa', 'stefano', 'corsetti', 'a123', 'via dei gerani', 'stefanocorsetti@live.it', 'pescosolido', 'utenteSemplice'),
('tommasoa', 'tommaso', 'di salle', 'a123', 'via boh 21', 'tommasodisalle@gmail.com', 'raiano', 'utenteSemplice');

-- --------------------------------------------------------

--
-- Struttura della tabella `utentegruppo`
--

CREATE TABLE `utentegruppo` (
  `username` varchar(10) NOT NULL,
  `id_gruppo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utentetrofeo`
--

CREATE TABLE `utentetrofeo` (
  `username` varchar(50) NOT NULL,
  `id_trofeo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `gioco`
--
ALTER TABLE `gioco`
  ADD PRIMARY KEY (`titolo`);

--
-- Indici per le tabelle `gruppo`
--
ALTER TABLE `gruppo`
  ADD PRIMARY KEY (`id_gruppo`);

--
-- Indici per le tabelle `grupposervizio`
--
ALTER TABLE `grupposervizio`
  ADD KEY `id_servizio` (`id_servizio`),
  ADD KEY `id_gruppo` (`id_gruppo`);

--
-- Indici per le tabelle `immagine`
--
ALTER TABLE `immagine`
  ADD PRIMARY KEY (`id_immagine`);

--
-- Indici per le tabelle `immaginegioco`
--
ALTER TABLE `immaginegioco`
  ADD KEY `id_immagine` (`id_immagine`),
  ADD KEY `titolo` (`titolo`);

--
-- Indici per le tabelle `livello`
--
ALTER TABLE `livello`
  ADD PRIMARY KEY (`id_livello`),
  ADD KEY `titolo` (`titolo`),
  ADD KEY `id_trofeo` (`id_trofeo`);

--
-- Indici per le tabelle `partite`
--
ALTER TABLE `partite`
  ADD PRIMARY KEY (`id_partita`),
  ADD KEY `username` (`username`),
  ADD KEY `id_livello` (`id_livello`);

--
-- Indici per le tabelle `recensione`
--
ALTER TABLE `recensione`
  ADD PRIMARY KEY (`id_recensione`),
  ADD KEY `username` (`username`),
  ADD KEY `titolo` (`titoloGioco`);

--
-- Indici per le tabelle `servizio`
--
ALTER TABLE `servizio`
  ADD PRIMARY KEY (`id_servizio`);

--
-- Indici per le tabelle `trofeo`
--
ALTER TABLE `trofeo`
  ADD PRIMARY KEY (`id_trofeo`),
  ADD KEY `id_immagine` (`id_immagine`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`username`);

--
-- Indici per le tabelle `utentegruppo`
--
ALTER TABLE `utentegruppo`
  ADD KEY `username` (`username`),
  ADD KEY `id_gruppo` (`id_gruppo`);

--
-- Indici per le tabelle `utentetrofeo`
--
ALTER TABLE `utentetrofeo`
  ADD KEY `username` (`username`),
  ADD KEY `id_trofeo` (`id_trofeo`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `grupposervizio`
--
ALTER TABLE `grupposervizio`
  ADD CONSTRAINT `grupposervizio_ibfk_1` FOREIGN KEY (`id_servizio`) REFERENCES `servizio` (`id_servizio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `grupposervizio_ibfk_2` FOREIGN KEY (`id_gruppo`) REFERENCES `gruppo` (`id_gruppo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `immaginegioco`
--
ALTER TABLE `immaginegioco`
  ADD CONSTRAINT `immaginegioco_ibfk_1` FOREIGN KEY (`id_immagine`) REFERENCES `immagine` (`id_immagine`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `immaginegioco_ibfk_2` FOREIGN KEY (`titolo`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `livello`
--
ALTER TABLE `livello`
  ADD CONSTRAINT `livello_ibfk_1` FOREIGN KEY (`titolo`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `livello_ibfk_2` FOREIGN KEY (`id_trofeo`) REFERENCES `trofeo` (`id_trofeo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `partite`
--
ALTER TABLE `partite`
  ADD CONSTRAINT `partite_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `partite_ibfk_2` FOREIGN KEY (`id_livello`) REFERENCES `livello` (`id_livello`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `recensione`
--
ALTER TABLE `recensione`
  ADD CONSTRAINT `recensione_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `recensione_ibfk_2` FOREIGN KEY (`titoloGioco`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `trofeo`
--
ALTER TABLE `trofeo`
  ADD CONSTRAINT `trofeo_ibfk_1` FOREIGN KEY (`id_immagine`) REFERENCES `immagine` (`id_immagine`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `utentegruppo`
--
ALTER TABLE `utentegruppo`
  ADD CONSTRAINT `utentegruppo_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utentegruppo_ibfk_2` FOREIGN KEY (`id_gruppo`) REFERENCES `gruppo` (`id_gruppo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `utentetrofeo`
--
ALTER TABLE `utentetrofeo`
  ADD CONSTRAINT `utentetrofeo_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utentetrofeo_ibfk_2` FOREIGN KEY (`id_trofeo`) REFERENCES `trofeo` (`id_trofeo`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
