-- Crear la tabla de usuarios
CREATE TABLE users (
    id UUID PRIMARY KEY,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified TIMESTAMP,
    lastLogin TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
);

-- Crear la tabla de información de usuarios
CREATE TABLE user_info (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Crear la tabla de teléfonos
CREATE TABLE phones (
    id UUID PRIMARY KEY,
    user_info_id UUID NOT NULL,
    number VARCHAR(20) NOT NULL,
    city_code VARCHAR(10) NOT NULL,
    country_code VARCHAR(10) NOT NULL,
    FOREIGN KEY (user_info_id) REFERENCES user_info(id)
);
