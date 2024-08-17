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
