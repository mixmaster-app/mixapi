INSERT INTO `character_type` (`id`, `name`, `img_url`) VALUES
	(1, 'Ditt', NULL),
	(2, 'Jin', NULL),
	(3, 'Penril', NULL),
	(4, 'Phoy', NULL);

INSERT INTO `hench_type` (`id`, `name`) VALUES
	(1, 'Dragon'),
	(2, 'Démon'),
	(3, 'Bête'),
	(4, 'Oiseau'),
	(5, 'Insecte'),
	(6, 'Plante'),
	(7, 'Mystère'),
	(8, 'Métal');

INSERT INTO `item_category` (`id`, `name`) VALUES
	(1, 'mix'),
	(2, 'craft');

INSERT INTO `item` (`id`, `name`, `description`, `item_category_id`) VALUES
	(17, 'SANG DE DRAGON', NULL, 1),
	(18, 'TOUCHER DÉMONIAQUE', NULL, 1),
	(19, 'COEUR VIGOUREUX', NULL, 1),
	(20, 'PLUME DE FEU', NULL, 1),
	(21, 'AMBRE DE CRISTAL MILLÉNAIRE', NULL, 1),
	(22, 'GRAINE DE L\'ARBRE DE VIE', NULL, 1),
	(23, 'TOURBILLON DE RÊVE', NULL, 1),
	(24, 'BIJOU EN MITHRIL', NULL, 1),
	(25, 'ITEM NIVEAU 4 DRAGON', NULL, 1),
	(26, 'ITEM NIVEAU 4 DÉMON', NULL, 1),
	(27, 'ITEM NIVEAU 4 BÊTE', NULL, 1),
	(28, 'ITEM NIVEAU 4 OISEAU', NULL, 1),
	(29, 'ITEM NIVEAU 4 INSECTE', NULL, 1),
	(30, 'ITEM NIVEAU 4 PLANTE', NULL, 1),
	(31, 'ITEM NIVEAU 4 MYSTÈRE', NULL, 1),
	(32, 'ITEM NIVEAU 4 MÉTAL', NULL, 1),
	(33, 'DRAGON FLAMBOYANT', NULL, 1),
	(34, 'LIVRE MAGIQUE DES TÉNÈBRES', NULL, 1),
	(35, 'CORNE DE LICORNE', NULL, 1),
	(36, 'AILE D\'ANGE', NULL, 1),
	(37, 'INSECTE FOSSILISÉ', NULL, 1),
	(38, 'FLEUR DE VIE', NULL, 1),
	(39, 'AME DU TRÉSOR', NULL, 1),
	(40, 'CŒUR FORT', NULL, 1);

INSERT INTO `mixmaster`.`hench_gender` (`id`, `name`) VALUES
    (0, 'Femelle'),
    (1, 'Male');

INSERT INTO `mixmaster`.`hench_nature` (`id`, `name`) VALUES
    (5, 'Puissant'),
    (4, 'Vif'),
    (3, 'Agile'),
    (2, 'Elemental'),
    (1, 'Chanceux');