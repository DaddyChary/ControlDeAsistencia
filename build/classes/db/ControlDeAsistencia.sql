-- Borra la base de datos si ya existe
DROP DATABASE IF EXISTS control_de_asistencia;

-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS control_de_asistencia;

-- Usa la base de datos recién creada
USE control_de_asistencia;

-- Crea la tabla de usuarios
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    rut VARCHAR(255) NOT NULL,
    clave VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    rol ENUM('empleado', 'administrador') NOT NULL
);

-- Crea la tabla de asistencias
CREATE TABLE asistencias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario_fk INT NOT NULL,
    fecha DATE NOT NULL,
    hora_entrada TIME,
    hora_salida TIME,
    FOREIGN KEY (id_usuario_fk) REFERENCES usuarios(id),
    UNIQUE (id_usuario_fk, fecha)
);


-- Inserta usuarios
INSERT INTO usuarios (nombre, apellido, rut, clave, email, rol) VALUES
('Juan', 'Pérez', '12345678-9', 'clave1', 'juan.perez@example.com', 'empleado'),
('María', 'Gómez', '23456789-0', 'clave2', 'maria.gomez@example.com', 'empleado'),
('Carlos', 'Sánchez', '34567890-1', 'clave3', 'carlos.sanchez@example.com', 'empleado'),
('Ana', 'López', '45678901-2', 'clave4', 'ana.lopez@example.com', 'administrador');

-- Inserta asistencias
INSERT INTO asistencias (id_usuario_fk, fecha, hora_entrada, hora_salida) VALUES
(1, '2024-08-20', '09:05:00', '18:00:00'),  -- Juan Pérez - Llega tarde
(2, '2024-08-20', '08:55:00', '17:55:00'),  -- María Gómez - Sale temprano
(3, '2024-08-20', '09:00:00', '18:00:00'),  -- Carlos Sánchez - Asistencia normal
(4, '2024-08-20', '08:50:00', '18:05:00'),  -- Ana López - Asistencia normal

(1, '2024-08-21', '09:10:00', '17:50:00'),  -- Juan Pérez - Llega tarde y sale temprano
(2, '2024-08-21', '09:00:00', '18:00:00'),  -- María Gómez - Asistencia normal
(3, '2024-08-21', '08:55:00', '18:10:00'),  -- Carlos Sánchez - Asistencia normal
(4, '2024-08-21', '09:05:00', '17:45:00');  -- Ana López - Llega tarde y sale temprano


