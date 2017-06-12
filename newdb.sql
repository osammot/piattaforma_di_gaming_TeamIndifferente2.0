-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Creato il: Giu 12, 2017 alle 15:41
-- Versione del server: 5.6.33
-- Versione PHP: 5.6.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

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
  `mediaVoto` float NOT NULL DEFAULT '2.5',
  `descrizione` text NOT NULL,
  `valore` int(10) NOT NULL,
  `template` varchar(50) NOT NULL,
  `datainserimento` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `gioco`
--

INSERT INTO `gioco` (`titolo`, `genere`, `mediaVoto`, `descrizione`, `valore`, `template`, `datainserimento`) VALUES
('Age Of The Gods: King Of Olympus', 'casino', 2.5, 'Gioca con gli Dei dell Olimpo e prova a vincere!', 3, '', '2017-05-19 13:18:10'),
('Asteroids', 'arcade', 2.5, ' Il giocatore comanda una navicella intrappolata in un campo di asteroidi. Lo scopo Ë distruggere tutti gli asteroidi nelle vicinanze', 6, '', '2017-05-19 13:18:10'),
('Blood Suckers', 'casino', 2.5, 'Blood Suckers Ë una slot ispirata al mondo dei vampiri. Almeno tre simboli bonus consentono al giocatore di accedere allíagghiacciante Bonus Game Vampire Slaying.', 3, '', '2017-05-19 13:18:10'),
('Pac-Man', 'arcade', 2.5, 'l giocatore deve guidare una creatura sferica di colore giallo chiamata Pac-Man facendole mangiare tutti i numerosi puntini disseminati ordinatamente all interno del labirinto e nel far questo deve evitare di farsi toccare da quattro fantasmi, pena la perdita immediata di una delle vite a disposizione. ', 6, '', '2017-05-19 13:18:10'),
('Space Invaders', 'arcade', 2.5, ' il giocatore controlla un cannone mobile che si muove orizzontalmente sul fondo dello schermo e deve abbattere uno ad uno gli alieni che piano piano si avvicinano alla Terra', 6, '', '2017-05-19 13:18:10'),
('Starburst', 'casino', 2.5, 'Starburst Ë una slot video con 5 ruote e 3 file che presenta il Jolly Starburst con giri ripetuti e vincite in entrambi i sensi.', 3, '', '2017-05-19 13:18:10'),
('Tetris', 'arcade', 2.5, 'I vari pezzi del gioco di Tetris si chiamano tetramini. Ciascuno composto da quattro blocchi. I tetramini cadono gi? uno alla volta e il compito del giocatore Ë ruotarli e/o muoverli in modo che creino una riga orizzontale di blocchi senza interruzioni. Quando la riga Ë stata creata i mattoni spariscono e i pezzi sovrastanti (se ce ne sono) cadono a formare nuove linee.', 6, '', '2017-05-19 13:18:10'),
('The Big Easy', 'casino', 2.5, 'La slot The Big Easy offre cinque rulli e 20 linee, oltre a giocate per raddoppiare e triplicare le vincite', 3, '', '2017-05-19 13:18:10'),
('Treasures of the Pyramids', 'casino', 2.5, 'Gioca alla slot machine Treasures of the Pyramids e vai alla ricerca dellíantico Tesoro della Piramide. ', 3, '', '2017-05-19 13:18:10');

-- --------------------------------------------------------

--
-- Struttura della tabella `gruppo`
--

CREATE TABLE `gruppo` (
  `id_gruppo` int(10) NOT NULL,
  `nomeGruppo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `gruppo`
--

INSERT INTO `gruppo` (`id_gruppo`, `nomeGruppo`) VALUES
(1, 'admin'),
(2, 'moderatore2'),
(3, 'moderatore3'),
(4, 'utente');

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
  `pathImmagine` varchar(500) NOT NULL,
  `titoloImmagine` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dump dei dati per la tabella `immagine`
--

INSERT INTO `immagine` (`id_immagine`, `pathImmagine`, `titoloImmagine`) VALUES
(1, 'img/game1.jpg', 'immagine gioco '),
(2, 'img/game2.jpg', 'immagine gioco '),
(3, 'img/game3.jpg', 'immagine gioco '),
(4, 'img/game4.jpg', 'immagine gioco '),
(5, 'img/game5.jpg', 'immagine gioco '),
(6, 'img/game6.jpg', 'immagine gioco '),
(7, 'img/game7.jpg', 'immagine gioco '),
(8, 'img/game8.jpg', 'immagine gioco '),
(9, 'img/game9.jpg', 'immagine gioco '),
(10, 'img/game10.jpg', 'immagine gioco'),
(11, 'img/game11.jpg', 'immagine gioco'),
(12, 'img/game12.jpg', 'immagine gioco'),
(13, 'img/game13.jpg', 'immagine gioco'),
(14, 'img/game14.jpg', 'immagine gioco'),
(15, 'img/game15.jpg', 'immagine gioco'),
(16, 'img/game16.jpg', 'immagine gioco'),
(17, 'img/trofeo1.jpg', 'immagine trofeo'),
(18, 'img/trofeo2.jpg', 'immagine trofeo'),
(19, 'img/trofeo3.jpg', 'immagine trofeo'),
(20, 'img/trofeo4.png', 'immagine trofeo');

-- --------------------------------------------------------

--
-- Struttura della tabella `immaginegioco`
--

CREATE TABLE `immaginegioco` (
  `id_immagine` int(10) NOT NULL,
  `titolo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `immaginegioco`
--

INSERT INTO `immaginegioco` (`id_immagine`, `titolo`) VALUES
(1, 'tetris'),
(2, 'Age Of The Gods: King Of Olympus'),
(3, 'Asteroids'),
(4, 'Blood Suckers'),
(5, 'Pac-Man '),
(6, 'Space Invaders'),
(7, 'Starburst'),
(8, 'The Big Easy'),
(9, 'Treasures of the Pyramids');

-- --------------------------------------------------------

--
-- Struttura della tabella `livello`
--

CREATE TABLE `livello` (
  `id_livello` int(10) NOT NULL,
  `numeroLivello` int(10) NOT NULL,
  `punteggioProssimoLivello` bigint(50) NOT NULL,
  `titologiocolivello` varchar(50) NOT NULL,
  `id_trofeolivello` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `livello`
--

INSERT INTO `livello` (`id_livello`, `numeroLivello`, `punteggioProssimoLivello`, `titologiocolivello`, `id_trofeolivello`) VALUES
(1, 0, 100, 'tetris', 4),
(2, 1, 200, 'tetris', 3),
(3, 2, 400, 'tetris', 2),
(4, 3, 800, 'tetris', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `partita`
--

CREATE TABLE `partita` (
  `id_partita` int(10) NOT NULL,
  `punteggio` bigint(50) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usernamepartita` varchar(50) NOT NULL,
  `id_livellopartita` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `recensione`
--

CREATE TABLE `recensione` (
  `id_recensione` int(10) NOT NULL,
  `titoloRecensione` varchar(50) NOT NULL,
  `testo` text NOT NULL,
  `approvata` tinyint(1) NOT NULL DEFAULT '0',
  `usernamerec` varchar(50) NOT NULL,
  `titologiocorec` varchar(50) NOT NULL,
  `datainserimento` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `recensione`
--

INSERT INTO `recensione` (`id_recensione`, `titoloRecensione`, `testo`, `approvata`, `usernamerec`, `titologiocorec`, `datainserimento`) VALUES
(1, 'male', 'testotexttestotext', 0, 'tommasoa', 'tetris', '2017-05-19 13:18:12'),
(2, 'dsdds', 'sdsdsdadaasd', 0, 'stefanoa', 'Tetris', '2017-06-12 11:00:19');

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
  `id_immaginetrofeo` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `trofeo`
--

INSERT INTO `trofeo` (`id_trofeo`, `nome`, `id_immaginetrofeo`) VALUES
(1, 'diamante', 20),
(2, 'oro', 17),
(3, 'argento', 18),
(4, 'bronzo', 19);

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
('eugenioa', 'eugenio', 'mancini', 'a123', 'via tre ponti', 'eugenio@live.it', 'avezzano', 'utente'),
('lucaa', 'luca', 'dorazio', 'a123', 'via fiume', 'lucaadorazio@gmail.com', 'roccavivi', 'amministratore'),
('stefanoa', 'stefano', 'corsetti', 'a123', 'via dei gerani', 'stefanocorsetti@live.it', 'pescosolido', 'moderatore'),
('tommasoa', 'tommaso', 'di salle', 'a123', 'via boh 21', 'tommasodisalle@gmail.com', 'raiano', 'moderatore');

-- --------------------------------------------------------

--
-- Struttura della tabella `utentegruppo`
--

CREATE TABLE `utentegruppo` (
  `username` varchar(10) DEFAULT NULL,
  `id_gruppo` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utentegruppo`
--

INSERT INTO `utentegruppo` (`username`, `id_gruppo`) VALUES
('lucaa', 1),
('tommasoa', 2),
('stefanoa', 3),
('eugenioa', 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `utentetrofeo`
--

CREATE TABLE `utentetrofeo` (
  `username` varchar(50) NOT NULL,
  `id_trofeo` int(10) NOT NULL,
  `titologioco` varchar(50) NOT NULL,
  `dataconquistatrofeo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utentetrofeo`
--

INSERT INTO `utentetrofeo` (`username`, `id_trofeo`, `titologioco`, `dataconquistatrofeo`) VALUES
('tommasoa', 1, 'tetris', '2017-05-22 08:37:34');

-- --------------------------------------------------------

--
-- Struttura della tabella `voto`
--

CREATE TABLE `voto` (
  `usernamevoto` varchar(50) NOT NULL,
  `titologiocovoto` varchar(50) NOT NULL,
  `voto` int(1) NOT NULL
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
  ADD KEY `titologiocolivello` (`titologiocolivello`),
  ADD KEY `id_trofeolivello` (`id_trofeolivello`);

--
-- Indici per le tabelle `partita`
--
ALTER TABLE `partita`
  ADD PRIMARY KEY (`id_partita`),
  ADD KEY `usernamepartita` (`usernamepartita`),
  ADD KEY `id_livellopartita` (`id_livellopartita`);

--
-- Indici per le tabelle `recensione`
--
ALTER TABLE `recensione`
  ADD PRIMARY KEY (`id_recensione`),
  ADD KEY `usernamerec` (`usernamerec`),
  ADD KEY `titologiocorec` (`titologiocorec`);

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
  ADD KEY `id_immaginetrofeo` (`id_immaginetrofeo`);

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
  ADD KEY `id_trofeo` (`id_trofeo`),
  ADD KEY `username` (`username`),
  ADD KEY `titologioco` (`titologioco`);

--
-- Indici per le tabelle `voto`
--
ALTER TABLE `voto`
  ADD PRIMARY KEY (`usernamevoto`,`titologiocovoto`),
  ADD KEY `titologiocovoto` (`titologiocovoto`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `gruppo`
--
ALTER TABLE `gruppo`
  MODIFY `id_gruppo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `immagine`
--
ALTER TABLE `immagine`
  MODIFY `id_immagine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT per la tabella `livello`
--
ALTER TABLE `livello`
  MODIFY `id_livello` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `partita`
--
ALTER TABLE `partita`
  MODIFY `id_partita` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `recensione`
--
ALTER TABLE `recensione`
  MODIFY `id_recensione` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `servizio`
--
ALTER TABLE `servizio`
  MODIFY `id_servizio` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `trofeo`
--
ALTER TABLE `trofeo`
  MODIFY `id_trofeo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
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
  ADD CONSTRAINT `livello_ibfk_1` FOREIGN KEY (`titologiocolivello`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `livello_ibfk_2` FOREIGN KEY (`id_trofeolivello`) REFERENCES `trofeo` (`id_trofeo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `partita`
--
ALTER TABLE `partita`
  ADD CONSTRAINT `partita_ibfk_1` FOREIGN KEY (`usernamepartita`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `partita_ibfk_2` FOREIGN KEY (`id_livellopartita`) REFERENCES `livello` (`id_livello`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `recensione`
--
ALTER TABLE `recensione`
  ADD CONSTRAINT `recensione_ibfk_1` FOREIGN KEY (`usernamerec`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `recensione_ibfk_2` FOREIGN KEY (`titologiocorec`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `trofeo`
--
ALTER TABLE `trofeo`
  ADD CONSTRAINT `trofeo_ibfk_1` FOREIGN KEY (`id_immaginetrofeo`) REFERENCES `immagine` (`id_immagine`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `utentegruppo`
--
ALTER TABLE `utentegruppo`
  ADD CONSTRAINT `utentegruppo_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utentegruppo_ibfk_2` FOREIGN KEY (`id_gruppo`) REFERENCES `gruppo` (`id_gruppo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `utentetrofeo`
--
ALTER TABLE `utentetrofeo`
  ADD CONSTRAINT `utentetrofeo_ibfk_1` FOREIGN KEY (`id_trofeo`) REFERENCES `trofeo` (`id_trofeo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utentetrofeo_ibfk_2` FOREIGN KEY (`username`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utentetrofeo_ibfk_3` FOREIGN KEY (`titologioco`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `voto`
--
ALTER TABLE `voto`
  ADD CONSTRAINT `voto_ibfk_1` FOREIGN KEY (`usernamevoto`) REFERENCES `utente` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `voto_ibfk_2` FOREIGN KEY (`titologiocovoto`) REFERENCES `gioco` (`titolo`) ON DELETE CASCADE ON UPDATE CASCADE;
