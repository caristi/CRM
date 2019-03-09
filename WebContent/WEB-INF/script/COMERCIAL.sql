use comercial;

#
# Table structure for table cliente
#

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `cli_id` int(11) NOT NULL auto_increment,
  `cli_tip_docum` char(4) collate utf8_spanish_ci NOT NULL default '',
  `cli_num_docum` char(20) collate utf8_spanish_ci NOT NULL default '',
  `cli_nombre` char(200) collate utf8_spanish_ci NOT NULL default '' COMMENT 'Nombre o razon social',
  `cli_apellido1` char(25) collate utf8_spanish_ci default NULL,
  `cli_apellido2` char(25) collate utf8_spanish_ci default NULL,
  `cli_pais` char(50) collate utf8_spanish_ci default NULL,
  `cli_ciudad` char(100) collate utf8_spanish_ci default NULL,
  `cli_direccion` char(150) collate utf8_spanish_ci default NULL COMMENT 'Direccion domicilio',
  `cli_telefono` char(12) collate utf8_spanish_ci default NULL COMMENT 'Telefono fij',
  `cli_celular` char(12) collate utf8_spanish_ci default NULL,
  `cli_email` char(45) collate utf8_spanish_ci default NULL,
  `cli_estado` char(1) collate utf8_spanish_ci default NULL,
  `cli_contacto` char(200) collate utf8_spanish_ci default NULL,
  `cli_cargo_contacto` char(50) collate utf8_spanish_ci default NULL,
  `cli_tel_contacto` char(12) collate utf8_spanish_ci default NULL,
  `cli_email_contacto` char(100) collate utf8_spanish_ci default NULL,
  `cli_observaciones` char(100) collate utf8_spanish_ci default NULL,
  `usu_id` int(11) default NULL,
  PRIMARY KEY  (`cli_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=FIXED;

#
# Dumping data for table cliente
#

INSERT INTO `cliente` VALUES (1,'CC','16074051','JORGE EDUARDOs','GARCÍA VILLA',NULL,'COLOMBIA','MANIZALES','CASTILLA REAL','8737354','999999','83.jorge@gmail.com','A','CARLOS HUGO ARISTIZÁBAL','INGENIERO','8848659','carlos@gmail.com',NULL,1);
INSERT INTO `cliente` VALUES (2,'CC','16074052','PEDRITOs','GARCÍA.',NULL,'COLOMBIA','MANIZALES','CASTILLA REAL','8737354','3128334198','83.jorge@gmail.com','A','CARLOS HUGO ARISTIZÁBAL','INGENIERO','8848659','carlos@gmail.com',NULL,1);
INSERT INTO `cliente` VALUES (3,'CC','30401370','KREATIVA','',NULL,'COLOMBIA','MANIZALES','calle 47 # 29 - 46','8737354','3127961604','no tiene','A','juan miguel','comunity manager','3147403384','sin@gmail.com',NULL,1);
INSERT INTO `cliente` VALUES (4,'N','860007627-1','san luis','gonzaga',NULL,'','','','','','','A','jeg','','','',NULL,3);

#
# Table structure for table cliente_historico
#

DROP TABLE IF EXISTS `cliente_historico`;
CREATE TABLE `cliente_historico` (
  `clihis_id` int(11) NOT NULL auto_increment,
  `clihis_fecha` date default NULL,
  `clihis_hora` time default NULL,
  `clihis_tipo_contacto` varchar(50) collate utf8_spanish_ci default NULL,
  `clihis_descripcion` text collate utf8_spanish_ci,
  `usu_id` int(11) default NULL,
  `cli_id` int(11) default NULL,
  PRIMARY KEY  (`clihis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=FIXED;

#
# Dumping data for table cliente_historico
#

INSERT INTO `cliente_historico` VALUES (1,'2018-12-22','15:30:10','TELEFONICO','el cliente estuvo muy serio',1,2);
INSERT INTO `cliente_historico` VALUES (2,'2018-12-23',NULL,'CORREO ELECTRÓNICO','se le envió un correo con la presentación de la empresa',0,3);
INSERT INTO `cliente_historico` VALUES (3,'2018-12-23',NULL,'CORREO ELECTRÓNICO','se le envió un correo con la presentación de la empresa',0,3);
INSERT INTO `cliente_historico` VALUES (4,'2018-12-23',NULL,'CORREO ELECTRÓNICO','prueba con correo',0,4);
INSERT INTO `cliente_historico` VALUES (5,'2018-12-22',NULL,'PRESENCIAL','visita de presentación',0,4);

#
# Table structure for table compra
#

DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `com_id` int(11) NOT NULL auto_increment,
  `com_fecha` date NOT NULL default '0000-00-00',
  `com_cantidad` int(11) default NULL,
  `com_vlr_total` decimal(10,4) NOT NULL default '0.0000',
  `com_observacion` char(200) default NULL,
  `pro_id` int(11) default NULL,
  `usu_id` int(11) default NULL,
  PRIMARY KEY  (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

#
# Dumping data for table compra
#

/*!40101 SET NAMES latin1 */;

INSERT INTO `compra` VALUES (1,'2018-11-22',10,2500,'PRUEBA',1,NULL);
INSERT INTO `compra` VALUES (2,'2018-12-11',40,0,'',1,NULL);

/*!40101 SET NAMES utf8 */;

#
# Table structure for table cotizacion
#

DROP TABLE IF EXISTS `cotizacion`;
CREATE TABLE `cotizacion` (
  `cot_id` int(11) NOT NULL auto_increment,
  `cot_num` varchar(150) collate utf8_spanish_ci default '',
  `cot_fecha` date NOT NULL default '0000-00-00',
  `cot_vlr_sub_total` double(10,4) NOT NULL default '0.0000',
  `cot_vlr_iva_total` double(10,4) NOT NULL default '0.0000',
  `cot_vlr_total` double(10,4) NOT NULL default '0.0000',
  `cot_observacion` text collate utf8_spanish_ci,
  `cli_id` int(11) default NULL,
  `usu_id` int(11) default NULL,
  PRIMARY KEY  (`cot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

#
# Dumping data for table cotizacion
#

INSERT INTO `cotizacion` VALUES (1,'1','2018-11-15',2,1,3,NULL,2,1);
INSERT INTO `cotizacion` VALUES (2,'2','2018-11-20',3,1,4,NULL,2,1);
INSERT INTO `cotizacion` VALUES (3,'3','2018-11-20',1,1,2,NULL,1,2);
INSERT INTO `cotizacion` VALUES (4,'80','2018-11-28',50000,10000,60000,'',1,2);
INSERT INTO `cotizacion` VALUES (5,NULL,'2018-12-18',157517.5,17482.5,175000,'',1,2);
INSERT INTO `cotizacion` VALUES (6,NULL,'2019-01-03',315035,34965,350000,'',1,2);

#
# Table structure for table cotizacion_detalle
#

DROP TABLE IF EXISTS `cotizacion_detalle`;
CREATE TABLE `cotizacion_detalle` (
  `cotd_id` int(11) NOT NULL auto_increment,
  `cotd_cantidad` int(11) default NULL,
  `cotd_vlr_producto` double(10,4) default NULL,
  `cotd_descuento` double(10,4) default NULL,
  `cotd_vlr_iva` double(10,4) default NULL,
  `cotd_subtotal` double(10,4) default NULL,
  `pro_id` int(11) default NULL,
  `cot_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`cotd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table cotizacion_detalle
#

/*!40101 SET NAMES latin1 */;

INSERT INTO `cotizacion_detalle` VALUES (1,12,900,0,500,999.99,1,1);
INSERT INTO `cotizacion_detalle` VALUES (2,18,900,0,200,999.99,1,2);
INSERT INTO `cotizacion_detalle` VALUES (3,6,700,0,100,800,3,3);
INSERT INTO `cotizacion_detalle` VALUES (4,10,350000,0,0,350000,1,4);
INSERT INTO `cotizacion_detalle` VALUES (5,2,70000,0,0,70000,1,5);
INSERT INTO `cotizacion_detalle` VALUES (6,3,105000,0,0,105000,1,5);
INSERT INTO `cotizacion_detalle` VALUES (7,10,350000,0,0,350000,1,6);

/*!40101 SET NAMES utf8 */;

#
# Table structure for table opcion
#

DROP TABLE IF EXISTS `opcion`;
CREATE TABLE `opcion` (
  `opc_id` int(11) NOT NULL auto_increment,
  `opc_codigo` int(11) default '0',
  `opc_url` char(200) collate utf8_spanish_ci default NULL,
  `opc_descripcion` char(250) collate utf8_spanish_ci default NULL,
  `opc_tipo` char(45) collate utf8_spanish_ci default NULL,
  `opc_cod_princ` int(11) default NULL,
  `opc_icon` char(45) collate utf8_spanish_ci default NULL,
  `opc_fec_act` date default '0000-00-00',
  `opc_cod_usr` char(25) collate utf8_spanish_ci default NULL,
  PRIMARY KEY  (`opc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=FIXED;

#
# Dumping data for table opcion
#

INSERT INTO `opcion` VALUES (1,1,NULL,'Administración','M',0,NULL,'2018-11-08','CARISTI');
INSERT INTO `opcion` VALUES (2,2,'../producto/consultarProducto.jsf','Productos','S',1,'ui-icon-note','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (3,3,'../compra/consultarCompra.jsf','Entradas','S',1,'ui-icon-copy','2018-08-01','CARISTI');
INSERT INTO `opcion` VALUES (4,4,'../cliente/listadoCliente.jsf','Clientes','S',5,'ui-icon-person','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (5,5,NULL,'Gestion Clientes','M',0,NULL,'2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (6,6,'../cotizacion/consultarCotizacion.jsf','Cotizaciones','S',5,'ui-icon-note','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (7,7,'../salida/consultarSalida.jsf','Salidas','S',1,'ui-icon-home','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (8,8,NULL,'Reportes','M',0,NULL,'2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (9,9,'../reportes/ventasTotales.jsf','Ventas totales','S',8,'ui-icon-note','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (10,10,'../faces/contenedorGrupos.xhtml','Gestion Compras','S',8,'ui-icon-note','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (11,11,'../usuario/listadoUsuario.jsf','Usuarios','S',1,'ui-icon-person','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (12,12,'../proveedor/listadoProveedor.jsf','Proveedores','S',1,'ui-icon-folder-open','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (16,13,'../reportes/ventasXusuario.jsf','Ventas x Usuario','S',8,'ui-icon-note','2018-08-01','CARISTI');
INSERT INTO `opcion` VALUES (17,14,'../reportes/VentasProductos.jsf','Productos vendidos','S',8,'ui-icon-note','2018-11-01','CARISTI');
INSERT INTO `opcion` VALUES (18,15,'../venta/consultarVentas.jsf','Ordenes de venta','S',5,'ui-icon-note','2018-11-18','CARISTI');
INSERT INTO `opcion` VALUES (19,16,'../cliente_historico/listadoHistorico.jsf','Historico Clientes','S',5,'ui-icon-note','2018-12-22','JOEDGAVI');

#
# Table structure for table producto
#

DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `pro_id` int(11) NOT NULL auto_increment,
  `pro_referencia` char(250) character set utf8 default NULL,
  `pro_ruta_imagen` char(250) character set utf8 default NULL,
  `pro_nombre` char(200) character set utf8 NOT NULL default '',
  `pro_descripcion` char(250) character set utf8 default NULL,
  `pro_cantidad` decimal(10,0) default NULL,
  `pro_vlr_costo` double(10,2) default NULL,
  `pro_pct_iva` double(3,2) default NULL,
  `pro_vlr_venta` double(10,2) default NULL,
  `pro_unidad_medida` char(5) default NULL,
  `pro_material` char(250) character set utf8 default NULL,
  PRIMARY KEY  (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

#
# Dumping data for table producto
#

/*!40101 SET NAMES latin1 */;

INSERT INTO `producto` VALUES (1,'123','cod-3390788346625206096-caneca.jpg','caneca','caneca grande',150,15000,9.99,35000,'1','plastico');
INSERT INTO `producto` VALUES (2,'1234','cod-1746776316225275858-caneca.jpg','baston','',40,0,0,0,'','');
INSERT INTO `producto` VALUES (3,'','cod-1174045731387322671-HORARIO.jpg','basurero','basureros',0,0,0,0,'','');
INSERT INTO `producto` VALUES (4,'','cod-5091801199600075888-convocatoria.JPG','prueba','',0,0,0,0,'','');
INSERT INTO `producto` VALUES (5,'','cod-1174045731387322671-HORARIO.jpg','basurero','basureros',15,0,0,0,'','');
INSERT INTO `producto` VALUES (6,'1234','cod-1746776316225275858-caneca.jpg','baston','',40,0,0,10000,'','');

/*!40101 SET NAMES utf8 */;

#
# Table structure for table proveedor
#

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `pro_id` int(11) NOT NULL auto_increment,
  `pro_tip_docum` char(4) character set utf8 collate utf8_spanish_ci NOT NULL default '',
  `pro_num_docum` char(20) character set utf8 collate utf8_spanish_ci NOT NULL default '',
  `pro_nombre` char(200) character set utf8 collate utf8_spanish_ci NOT NULL default '' COMMENT 'Nombre o razon social',
  `pro_apellido1` char(25) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_apellido2` char(25) default NULL,
  `pro_pais` char(50) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_ciudad` char(100) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_direccion` char(150) character set utf8 collate utf8_spanish_ci default NULL COMMENT 'Direccion domicilio',
  `pro_telefono` char(12) character set utf8 collate utf8_spanish_ci default NULL COMMENT 'Telefono fij',
  `pro_celular` char(12) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_email` char(45) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_estado` char(1) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_contacto` char(200) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_cargo_contacto` char(50) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_tel_contacto` char(12) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_email_contacto` char(100) character set utf8 collate utf8_spanish_ci default NULL,
  `pro_observaciones` char(100) character set utf8 collate utf8_spanish_ci default NULL,
  PRIMARY KEY  (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table proveedor
#

INSERT INTO `proveedor` VALUES (1,'N','860007627-1','compañia de jesus','colegio san luis','gonzaga','colombia','pereira','calle 54 #27-35','8860414','','comu@sanl','N','julian','comunicaciones','313242','comunica@sas','ninguna');
INSERT INTO `proveedor` VALUES (2,'CC','sadfa','probando','','','','medellin','','','','','N','ninguno','','','','');

#
# Table structure for table salida
#

DROP TABLE IF EXISTS `salida`;
CREATE TABLE `salida` (
  `sal_id` int(11) NOT NULL auto_increment,
  `sal_fecha` date NOT NULL default '0000-00-00',
  `sal_observacion` text collate latin1_spanish_ci,
  `sal_mca_completada` char(1) collate latin1_spanish_ci NOT NULL default 'N',
  `sal_pct_avance` float default '0',
  `ven_id` int(11) NOT NULL default '0',
  `bod_id` int(11) NOT NULL default '0',
  `usu_id` int(11) NOT NULL default '0',
  `cli_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`sal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Dumping data for table salida
#

/*!40101 SET NAMES latin1 */;

INSERT INTO `salida` VALUES (3,'2019-01-03','','S',100,10,0,1,1);

/*!40101 SET NAMES utf8 */;

#
# Table structure for table salida_detalle
#

DROP TABLE IF EXISTS `salida_detalle`;
CREATE TABLE `salida_detalle` (
  `sald_id` int(11) NOT NULL auto_increment,
  `sald_cantidad_enviada` int(11) default NULL,
  `sald_cantidad_vendido` int(11) default NULL,
  `sald_fec_actu` datetime default NULL,
  `sald_fec_enviado` datetime default NULL,
  `sald_mca_enviada` char(1) collate latin1_spanish_ci default NULL,
  `sald_observacion` varchar(255) collate latin1_spanish_ci default NULL,
  `sald_pct_avance` float default NULL,
  `sal_id` int(11) default NULL,
  `pro_id` int(11) default NULL,
  `usu_id` int(11) default NULL,
  PRIMARY KEY  (`sald_id`),
  KEY `FK_metyn1gqwit2t2b8o6fycve9` (`pro_id`),
  KEY `FK_onj4imchgcbgx9hthb1r0r064` (`usu_id`),
  KEY `FK_9c213n3ofwm9dubu6q3hqn1ov` (`sal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Dumping data for table salida_detalle
#

/*!40101 SET NAMES latin1 */;

INSERT INTO `salida_detalle` VALUES (1,10,10,'2019-01-03 15:18:59','2019-02-26 16:54:10','S','',100,3,1,1);

/*!40101 SET NAMES utf8 */;

#
# Table structure for table usuario
#

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `usu_id` int(11) NOT NULL auto_increment,
  `usu_num_docum` char(15) default NULL,
  `usu_nombre` char(100) default NULL,
  `usu_apellido1` char(100) default NULL,
  `usu_apellido2` char(100) default NULL,
  `usu_login` char(100) NOT NULL default '',
  `usu_contrasena` char(40) NOT NULL default '',
  `usu_fecha_nacimiento` date default NULL,
  `usu_ciudad_nacimiento` char(15) default NULL,
  `usu_direccion` char(100) default NULL,
  `usu_telefono` char(15) default NULL,
  `usu_celular` char(15) default NULL,
  `usu_email` char(45) default NULL,
  `usu_cargo` char(45) default NULL,
  `usu_fecha_ingreso` date default NULL,
  `usu_perfil` char(10) character set utf8 collate utf8_spanish_ci default NULL,
  PRIMARY KEY  (`usu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

#
# Dumping data for table usuario
#

/*!40101 SET NAMES latin1 */;

INSERT INTO `usuario` VALUES (1,'123','GABRIELA MARÃA','GARCÃA','VILLA','123','123','2018-11-20','manizales','calle 47 # 29 - 46','8737475','3134444','no@gmail.com','director',NULL,'C');
INSERT INTO `usuario` VALUES (2,'456','JORGE EDUARDO','GARCÃA','VILLA','456','789','2011-02-11','manila','parque de castilla','8737354','3128334198','83.jorge@gmail.com','vendedor',NULL,'A');
INSERT INTO `usuario` VALUES (3,'786876','carlos','','','987','987',NULL,'','','','','','',NULL,'C');
INSERT INTO `usuario` VALUES (4,'987','julian','','','aaa','aaa','2018-11-17','','','','','','comunicador',NULL,'C');
INSERT INTO `usuario` VALUES (5,'898989','JUAN MIGUEL','OSORIO','','JUAN','OSORIO','2007-03-10','','','','','','','2018-11-26','C');

/*!40101 SET NAMES utf8 */;

#
# Table structure for table venta_cabecera
#

DROP TABLE IF EXISTS `venta_cabecera`;
CREATE TABLE `venta_cabecera` (
  `ven_id` int(11) NOT NULL auto_increment,
  `ven_num` varchar(50) collate utf8_spanish_ci default '',
  `ven_fecha` date NOT NULL default '0000-00-00',
  `ven_vlr_sub_total` double(10,4) NOT NULL default '0.0000',
  `ven_vlr_descuento` double(10,4) default NULL,
  `ven_vlr_iva_total` double(10,4) NOT NULL default '0.0000',
  `ven_vlr_total` double(10,4) NOT NULL default '0.0000',
  `ven_observacion` text collate utf8_spanish_ci,
  `cli_id` int(11) default NULL,
  `usu_id` int(11) default NULL,
  `cot_id` int(11) default NULL,
  PRIMARY KEY  (`ven_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=FIXED;

#
# Dumping data for table venta_cabecera
#

INSERT INTO `venta_cabecera` VALUES (1,'1','2018-11-15',2,NULL,1,20000,NULL,2,1,NULL);
INSERT INTO `venta_cabecera` VALUES (2,'2','2018-11-20',3,NULL,1,40000,NULL,2,1,NULL);
INSERT INTO `venta_cabecera` VALUES (3,'3','2018-11-20',1,NULL,1,10000,NULL,1,2,NULL);
INSERT INTO `venta_cabecera` VALUES (4,'4','2018-11-30',0,NULL,0,0,NULL,1,1,NULL);
INSERT INTO `venta_cabecera` VALUES (6,NULL,'2018-12-18',50000,0,10000,60000,'',1,2,4);
INSERT INTO `venta_cabecera` VALUES (7,NULL,'2018-12-18',157517.5,0,17482.5,175000,'',1,2,5);
INSERT INTO `venta_cabecera` VALUES (8,NULL,'2019-01-03',315035,0,34965,350000,'',1,2,6);
INSERT INTO `venta_cabecera` VALUES (9,NULL,'2019-01-03',315035,0,34965,350000,'',1,2,6);
INSERT INTO `venta_cabecera` VALUES (10,NULL,'2019-01-03',315035,0,34965,350000,'',1,2,6);

#
# Table structure for table venta_detalle
#

DROP TABLE IF EXISTS `venta_detalle`;
CREATE TABLE `venta_detalle` (
  `vend_id` int(11) NOT NULL auto_increment,
  `vend_cantidad` double(10,4) default NULL,
  `vend_vlr_producto` double(10,4) default NULL,
  `vend_vlr_descuento` double(10,4) default NULL,
  `vend_vlr_iva` double(10,4) default NULL,
  `vend_subtotal` double(10,4) default NULL,
  `pro_id` int(11) default NULL,
  `ven_id` int(11) NOT NULL default '0',
  PRIMARY KEY  (`vend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table venta_detalle
#

/*!40101 SET NAMES latin1 */;

INSERT INTO `venta_detalle` VALUES (1,12,900,0,500,999.99,1,1);
INSERT INTO `venta_detalle` VALUES (2,18,900,0,200,999.99,1,2);
INSERT INTO `venta_detalle` VALUES (3,7,700,0,100,800,3,3);
INSERT INTO `venta_detalle` VALUES (4,10,350000,0,12000,350000,1,4);
INSERT INTO `venta_detalle` VALUES (5,10,350000,0,0,350000,1,6);
INSERT INTO `venta_detalle` VALUES (6,2,70000,0,0,70000,1,7);
INSERT INTO `venta_detalle` VALUES (7,3,105000,0,0,105000,1,7);
INSERT INTO `venta_detalle` VALUES (8,10,350000,0,0,350000,1,8);
INSERT INTO `venta_detalle` VALUES (9,10,350000,0,0,350000,1,9);
INSERT INTO `venta_detalle` VALUES (10,10,350000,0,0,350000,1,10);

/*!40101 SET NAMES utf8 */;

/*!40101 SET NAMES latin1 */;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
