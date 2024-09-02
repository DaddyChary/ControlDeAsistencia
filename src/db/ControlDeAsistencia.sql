-- Borra la base de datos si ya existe
DROP DATABASE IF EXISTS control_de_asistencia;

-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS control_de_asistencia;

-- Usa la base de datos recién creada
USE control_de_asistencia;

-- Crea la tabla de usuarios
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    rut VARCHAR(13) NOT NULL,
    clave VARCHAR(64) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    rol ENUM('empleado', 'administrador') NOT NULL,
    activo BOOLEAN DEFAULT TRUE  -- Añadido campo 'activo' directamente aquí
);

-- Crea la tabla de asistencias
CREATE TABLE asistencias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario_fk INT NOT NULL,
    fecha DATE NOT NULL,
    hora_entrada VARCHAR(30),
    hora_salida VARCHAR(30),
    FOREIGN KEY (id_usuario_fk) REFERENCES usuarios(id),
    UNIQUE (id_usuario_fk, fecha)
);

-- Inserta usuarios
INSERT INTO usuarios (nombre, apellido, rut, clave, email, rol) VALUES
('admin', 'admin', '12345678-9', 'admin', 'admin', 'administrador');
