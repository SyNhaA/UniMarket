insert into usuario values ("0000000001", "contrasenia1", "juan.perez@gmail.com", "Juan Perez", "Calle 123, Ciudad", "(123) 456-7890");
insert into usuario values ("0000000002", "contrasenia2", "maria.garcia@hotmail.com", "Maria Garcia", "Avenida 456, Pueblo", "(234) 567-8901");
insert into usuario values ("0000000003", "contrasenia3", "luis.rodriguez@yahoo.com", "Luis Rodriguez", "Calle 789, Villa", "(345) 678-9012");
insert into usuario values ("0000000004", "contrasenia4", "ana.martinez@gmail.com", "Ana Martinez", "Avenida 987, Ciudad", "(456) 789-0123");
insert into usuario values ("0000000005", "contrasenia5", "carlos.gomez@hotmail.com", "Carlos Gomez", "Calle 345, Pueblo", "(567) 890-1234");
insert into usuario values ("0000000006", "contrasenia6", "laura.hernandez@yahoo.com", "Laura Hernandez", "Avenida 123, Villa", "(678) 901-2345");
insert into usuario values ("0000000007", "contrasenia7", "pedro.gonzalez@gmail.com", "Pedro Gonzalez", "Calle 567, Ciudad", "(789) 012-3456");
insert into usuario values ("0000000008", "contrasenia8", "marta.diaz@hotmail.com", "Marta Diaz",  "Avenida 890, Pueblo", "(890) 123-4567");
insert into usuario values ("0000000009", "contrasenia9", "jorge.sanchez@yahoo.com", "Jorge Sanchez", "Calle 901, Villa", "(901) 234-5678");
insert into usuario values ("0000000010", "contrasenia10", "sofia.romero@gmail.com", "Sofia Romero", "Avenida 234, Ciudad", "(012) 345-6789");

insert into moderador values ("0000000011", "contrasena1", "juanperez@gmail.com", "Juan Perez");
insert into moderador values ("0000000012", "contrasena2", "anarodriguez@hotmail.com", "Ana Rodriguez");
insert into moderador values ("0000000013", "contrasena3", "luisagonzalez@yahoo.com", "Luisa Gonzalez");
insert into moderador values ("0000000014", "contrasena4", "pedroramirez@gmail.com", "Pedro Ramirez");
insert into moderador values ("0000000015", "contrasena5", "mariamartinez@hotmail.com", "Maria Martinez");
insert into moderador values ("0000000016", "contrasena6", "carloslopez@yahoo.com", "Carlos Lopez");
insert into moderador values ("0000000017", "contrasena7", "sofiahernandez@gmail.com", "Sofia Hernandez");
insert into moderador values ("0000000018", "contrasena8", "diegogarcia@hotmail.com", "Diego Garcia");
insert into moderador values ("0000000019", "contrasena9", "lauragomez@yahoo.com", "Laura Gomez");
insert into moderador values ("0000000020", "contrasena10", "josefernandez@gmail.com", "Jose Fernandez");

insert into producto values (1, 1, "TECNOLOGIA", "Smartphone Samsung Galaxy S21 Ultra 5G 256GB", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "Samsung Galaxy S21 Ultra 5G", 1699.99, 10, "0000000001");
insert into producto values (2, 0, "TECNOLOGIA", "Laptop Apple MacBook Pro 2021 13\" M1 256GB", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "Apple MacBook Pro 2021", 1299.99, 5, "0000000002");
insert into producto values (3, 1, "TECNOLOGIA", "Smartwatch Apple Watch Series 7 45mm GPS", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "Apple Watch Series 7", 429.99, 20, "0000000003");
insert into producto values (4, 1, "TECNOLOGIA", "Smart TV Samsung 75\" QLED 4K Ultra HD", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "Samsung QLED 4K Ultra HD", 2699.99, 3, "0000000004");
insert into producto values (5, 0, "TECNOLOGIA", "Tablet Apple iPad Pro 2021 11\" M1 128GB", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "Apple iPad Pro 2021", 799.99, 8, "0000000005");
insert into producto values (6, 1, "TECNOLOGIA", "Smartphone OnePlus 10 Pro 5G 256GB", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "OnePlus 10 Pro 5G", 1099.99, 15, "0000000006");
insert into producto values (7, 1, "TECNOLOGIA", "Smart TV LG 65\" OLED 4K Ultra HD", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "LG OLED 4K Ultra HD", 1999.99, 4, "0000000007");
insert into producto values (8, 0, "TECNOLOGIA", "Laptop Microsoft Surface Laptop 4 13.5\" Ryzen 5 8GB RAM 256GB SSD", "2023-05-13 20:25:10.123456", "2023-08-13 20:25:10.123456", "Microsoft Surface Laptop 4", 999.99, 6, "0000000008");
insert into producto values (9, 0, "TECNOLOGIA", "Cámara fotográfica Canon EOS R", "2023-05-13 14:23:00"    , "2023-08-13 14:23:00", "Canon EOS R", 2200, 7, "0000000009");
insert into producto values (10, 1, "TECNOLOGIA", "Monitor de computadora Asus ROG Swift PG279QZ", "2023-05-13 14:23:00", "2023-08-13 14:23:00", "Asus ROG Swift PG279QZ", 800, 12, "0000000010");

insert into comentario values (1, "2023-04-27 12:00:00", "Muy buen producto", 3, "0000000001");
insert into comentario values (2, "2023-04-27 13:30:00", "No lo recomiendo", 4, "0000000001");
insert into comentario values (3, "2023-04-27 15:00:00", "Excelente relación calidad-precio", 2, "0000000001");
insert into comentario values (4, "2023-04-27 16:30:00", "Buen producto pero se calienta demasiado", 1, "0000000001");
insert into comentario values (5, "2023-04-27 18:00:00", "Funciona perfectamente, lo recomiendo", 5, "0000000001");
insert into comentario values (6, "2023-04-27 19:30:00", "No cumplió mis expectativas", 6, "0000000001");
insert into comentario values (7, "2023-04-27 21:00:00", "Muy satisfecho con mi compra", 10, "0000000001");
insert into comentario values (8, "2023-04-27 22:30:00", "No funcionó correctamente desde el primer día", 9, "0000000001");
insert into comentario values (9, "2023-04-28 10:00:00", "El producto llegó en perfectas condiciones", 4, "0000000001");
insert into comentario values (10, "2023-04-28 11:30:00", "Cumplió con mis expectativas", 8, "0000000001");

insert into compra values (1, "2023-04-27 12:00:00", "EFECTIVO", 15000, "0000000001");

insert into detallecompra values (1, 50000, 12, 1, 1);