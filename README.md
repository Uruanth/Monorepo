# Monorepo
 App modular con gradle

## Tables DDL
~~~sql
-- pragma.categoria definition

CREATE TABLE `categoria` (
  `id` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- pragma.roles definition

CREATE TABLE `roles` (
  `id` int NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- pragma.usuarios definition

CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `id_rol` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3kl77pehgupicftwfreqnjkll` (`id_rol`),
  CONSTRAINT `FK3kl77pehgupicftwfreqnjkll` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- pragma.restaurante definition

CREATE TABLE `restaurante` (
  `id` int NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `id_propietario` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `nit` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `url_logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- pragma.plato definition

CREATE TABLE `plato` (
  `id` int NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `url_imagen` varchar(255) DEFAULT NULL,
  `id_categoria` int DEFAULT NULL,
  `id_restaurante` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK55wxa3u8lifql6rpbln7wvuwi` (`id_categoria`),
  KEY `FKg3tvsxnksbrt9isaictfbch2m` (`id_restaurante`),
  CONSTRAINT `FK55wxa3u8lifql6rpbln7wvuwi` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FKg3tvsxnksbrt9isaictfbch2m` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- pragma.pedido definition

CREATE TABLE `pedido` (
  `id` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `id_chef` int DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `id_restaurante` int DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_icp5bexdcv4xgningojhgplly` (`id_chef`),
  KEY `FK38kdlm6wkqjfk9l72iv55wg26` (`id_restaurante`),
  KEY `FKcf1w1gn4jvkpmbo722phkbo2t` (`id_cliente`),
  CONSTRAINT `FK38kdlm6wkqjfk9l72iv55wg26` FOREIGN KEY (`id_restaurante`) REFERENCES `restaurante` (`id`),
  CONSTRAINT `FKcf1w1gn4jvkpmbo722phkbo2t` FOREIGN KEY (`id_cliente`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- pragma.pedido_platos definition

CREATE TABLE `pedido_platos` (
  `id_plato` int NOT NULL,
  `id_orden` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id_plato`,`id_orden`),
  KEY `FKc1u6hoqxnkq5wiktn0lw4w4n7` (`id_orden`),
  CONSTRAINT `FK68a3ebm6v1c3x2ed7sd9e7m4h` FOREIGN KEY (`id_plato`) REFERENCES `plato` (`id`),
  CONSTRAINT `FKc1u6hoqxnkq5wiktn0lw4w4n7` FOREIGN KEY (`id_orden`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- pragma.restaurante_empleado definition

CREATE TABLE `restaurante_empleado` (
  `id` int NOT NULL,
  `field` varchar(255) DEFAULT NULL,
  `id_restaurante` int DEFAULT NULL,
  `id_persona` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6krwcghq7bu374bcbh0lf7ppk` (`id_restaurante`),
  KEY `FKd1hebib0qd98lt4w40ngs7aob` (`id_persona`),
  CONSTRAINT `FK6krwcghq7bu374bcbh0lf7ppk` FOREIGN KEY (`id_restaurante`) REFERENCES `pedido` (`id_chef`),
  CONSTRAINT `FKd1hebib0qd98lt4w40ngs7aob` FOREIGN KEY (`id_persona`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
~~~
