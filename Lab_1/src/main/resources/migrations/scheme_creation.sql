CREATE TABLE `electric_appliances` (
  `id_electric_appliances` int(11) NOT NULL AUTO_INCREMENT,
  `appliance_name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `power_watt` int(11) NOT NULL,
  `production_year` int(11) NOT NULL,
  `appliance_type` varchar(45) NOT NULL,
  `turned_on` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_electric_appliances`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `types` (
  `idTypes` int(11) NOT NULL AUTO_INCREMENT,
  `specific_types` varchar(45) DEFAULT NULL,
  `general_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTypes`),
  KEY `appliance_types_idx` (`specific_types`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

