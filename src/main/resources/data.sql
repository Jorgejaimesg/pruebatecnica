INSERT INTO categoria (nombre) VALUES
('Electronica'),
('Hogar'),
('Deportes'),
('Ropa'),
('Juguetes');

INSERT INTO producto (nombre, descripcion, precio, categoria_id) VALUES
('Televisor', 'Televisor LED de 42 pulgadas', 1200.50, 1),
('Smartphone', 'Telefono inteligente con 128GB de almacenamiento', 800.30, 1),
('Aspiradora', 'Aspiradora robot para limpieza automatica', 250.10, 2),
('Sofa', 'Sofa de 3 plazas con tapizado de cuero', 500.20, 2),
('Bicicleta', 'Bicicleta de pista con 21 velocidades', 300.00, 3),
('Balon de futbol', 'Balon oficial de tamaño 5', 25.00, 3),
('Camiseta', 'Camiseta deportiva de algodon', 20.00, 4),
('Pantalones', 'Pantalones de mezclilla para hombre', 40.00, 4),
('Barbie', 'Barbie articulada con accesorios', 35.00, 5),
('Puzzle', 'Rompecabezas de 1000 piezas', 15.00, 5);