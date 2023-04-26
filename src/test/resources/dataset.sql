insert into usuario values (1, "Juan Perez", "juan.perez@gmail.com", "Calle 123, Ciudad", "(123) 456-7890");
insert into usuario values (2, "Maria Garcia", "maria.garcia@hotmail.com", "Avenida 456, Pueblo", "(234) 567-8901");
insert into usuario values (3, "Luis Rodriguez", "luis.rodriguez@yahoo.com", "Calle 789, Villa", "(345) 678-9012");
insert into usuario values (4, "Ana Martinez", "ana.martinez@gmail.com", "Avenida 987, Ciudad", "(456) 789-0123");
insert into usuario values (5, "Carlos Gomez", "carlos.gomez@hotmail.com", "Calle 345, Pueblo", "(567) 890-1234");
insert into usuario values (6, "Laura Hernandez", "laura.hernandez@yahoo.com", "Avenida 123, Villa", "(678) 901-2345");
insert into usuario values (7, "Pedro Gonzalez", "pedro.gonzalez@gmail.com", "Calle 567, Ciudad", "(789) 012-3456");
insert into usuario values (8, "Marta Diaz", "marta.diaz@hotmail.com", "Avenida 890, Pueblo", "(890) 123-4567");
insert into usuario values (9, "Jorge Sanchez", "jorge.sanchez@yahoo.com", "Calle 901, Villa", "(901) 234-5678");
insert into usuario values (10, "Sofia Romero", "sofia.romero@gmail.com", "Avenida 234, Ciudad", "(012) 345-6789");

insert into producto values (1, "SINREVISAR", "2023-05-05T08:00:00", "Sony PlayStation 6", "La próxima generación de consolas de videojuegos con capacidad de 8K y trazado de rayos.", 100, 499.99, 2, "https://www.example.com/ps6.jpg", "https://www.example.com/ps6");
insert into producto values (2, "APROBADO", "2023-05-04T13:45:00", "LG 55-inch OLED TV", "Televisor OLED de 55 pulgadas con resolución 4K, HDR y tecnología Dolby Vision.", 20, 1299.99, 3, "https://www.example.com/lg-oled-tv.jpg", "https://www.example.com/lg-oled-tv");
insert into producto values (3, "RECHAZADO", "2023-05-03T14:30:00", "Google Pixel 7", "El último modelo de teléfono inteligente de Google con una pantalla AMOLED de 6,4 pulgadas y cámara trasera dual.", 50, 799.99, 4, "https://www.example.com/google-pixel-7.jpg", "https://www.example.com/google-pixel-7");
insert into producto values (4, "SINREVISAR", "2023-05-06T10:15:00", "Dell XPS 17", "Laptop con pantalla 4K de 17 pulgadas, procesador Intel Core i7 de décima generación y tarjeta gráfica NVIDIA GeForce GTX 1650 Ti.", 30, 1899.99, 5, "https://www.example.com/dell-xps-17.jpg", "https://www.example.com/dell-xps-17");
insert into producto values (5, "APROBADO", "2023-05-08T09:30:00", "Apple Watch Series 8", "El último modelo de reloj inteligente de Apple con seguimiento de la salud mejorado y una pantalla siempre encendida.", 100, 399.99, 6, "https://www.example.com/apple-watch-series-8.jpg", "https://www.example.com/apple-watch-series-8");
insert into producto values (6, "RECHAZADO", "2023-05-07T11:45:00", "Samsung Galaxy Tab S8", "Tablet con pantalla AMOLED de 11 pulgadas, procesador Snapdragon 888 y cámara trasera dual.", 50, 899.99, 7, "https://www.example.com/samsung-galaxy-tab-s8.jpg", "https://www.example.com/samsung-galaxy-tab-s8");
insert into producto values (7, "SINREVISAR", "2023-05-09T14:00:00", "Bose QuietComfort 55", "Audífonos inalámbricos con cancelación de ruido activa y hasta 20 horas de duración de la batería.", 50, 299.99, 8, "https://www.example.com/bose-qc-55.jpg", "https://www.example.com/bose-qc-55");

insert into comentario values (1, "2023-04-27 12:00:00", "Muy buen producto", 3, 2);
insert into comentario values (2, "2023-04-27 13:30:00", "No lo recomiendo", 4, 1);
insert into comentario values (3, "2023-04-27 15:00:00", "Excelente relación calidad-precio", 2, 5);
insert into comentario values (4, "2023-04-27 16:30:00", "Buen producto pero se calienta demasiado", 1, 8);
insert into comentario values (5, "2023-04-27 18:00:00", "Funciona perfectamente, lo recomiendo", 5, 7);
insert into comentario values (6, "2023-04-27 19:30:00", "No cumplió mis expectativas", 6, 3);
insert into comentario values (7, "2023-04-27 21:00:00", "Muy satisfecho con mi compra", 10, 4);
insert into comentario values (8, "2023-04-27 22:30:00", "No funcionó correctamente desde el primer día", 9, 1);
insert into comentario values (9, "2023-04-28 10:00:00", "El producto llegó en perfectas condiciones", 4, 9);
insert into comentario values (10, "2023-04-28 11:30:00", "Cumplió con mis expectativas", 8, 6);

insert into detalleCompra values (1, 50, 25.99);
insert into detalleCompra values (2, 120, 15.75);
insert into detalleCompra values (3, 80, 10.50);
insert into detalleCompra values (4, 30, 50.00);
insert into detalleCompra values (5, 100, 20.25);
insert into detalleCompra values (6, 70, 35.99);
insert into detalleCompra values (7, 45, 12.50);
insert into detalleCompra values (1, 90, 8.99);
insert into detalleCompra values (3, 110, 42.75);

insert into correo values ("Descuento especial", "Hola, ¡tenemos un descuento especial para ti! Obtén un 20% de descuento en todos nuestros productos esta semana. ¡No pierdas esta oportunidad!", "ejemplo@ejemplo.com");
insert into correo values ("Actualización de cuenta", "Estimado usuario, le informamos que su cuenta ha sido actualizada exitosamente. Ahora puede acceder a todas nuestras funciones premium. ¡Gracias por elegirnos!", "usuario1234@ejemplo.com");
insert into correo values ("Solicitud de información", "Buenos días, ¿podrían proporcionarme más información sobre su producto [nombre del producto]? Estoy interesado en comprarlo y me gustaría conocer más detalles. ¡Gracias!", "ejemplo2@ejemplo.com");

insert into sesion values ("ejemplo1@gmail.com", "contrasena1", 2);
insert into sesion values ("ejemplo2@gmail.com", "contrasena2", 3);
insert into sesion values ("ejemplo3@gmail.com", "contrasena3", 1);
insert into sesion values ("ejemplo4@gmail.com", "contrasena4", 2);
insert into sesion values ("ejemplo7@gmail.com", "contrasena7", 2);
insert into sesion values ("ejemplo8@gmail.com", "contrasena8", 1);
insert into sesion values ("ejemplo9@gmail.com", "contrasena9", 3);
insert into sesion values ("ejemplo10@gmail.com", "contrasena10", 1)

insert into token values ("qwerty123", "Activo");
insert into token values ("asdfg456", "Inactivo");
insert into token values ("zxcvb789", "Activo");
insert into token values ("poiuyt321", "Inactivo");
insert into token values ("lkjhgf654", "Activo");
insert into token values ("mnbvcx987", "Inactivo");
insert into token values ("0987ytrewq", "Activo");
insert into token values ("1234qwerasdf", "Inactivo");
insert into token values ("5678zxcvbnm", "Activo");
insert into token values ("mnbvcxzlkj", "Inactivo");